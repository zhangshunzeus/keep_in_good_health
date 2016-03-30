package com.dlazaro66.qrcodereaderview;

import android.R.integer;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.graphics.PointF;

import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.camera.open.CameraManager;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.zhangshun.keep_in_good_health.R;

import java.io.IOException;

/*
 * Copyright 2014 David Lázaro Esparcia.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * QRCodeReaderView - Class which uses ZXING lib and let you easily integrate a
 * QR decoder view. Take some classes and made some modifications in the
 * original ZXING - Barcode Scanner project. 扫描框的view
 * 
 * @author David Lázaro
 */
public class QRCodeReaderView extends SurfaceView implements
		SurfaceHolder.Callback, Camera.PreviewCallback {
	private Handler handler = new Handler() {
		// 自定义类的局部变量
		int i = 70;

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub

			Log.i("MyviewHander", heights + "");
			if (i == 70) {
				matrix.setTranslate(0, 0);
				i = 1;
			}
			i++;

			// sendEmptyMessageDelayed(1, 60);
			draw();
		}
	};

	public interface OnQRCodeReadListener {

		public void onQRCodeRead(String text, PointF[] points);

		public void cameraNotFound();

		public void QRCodeNotFoundOnCamImage();
	}

	private OnQRCodeReadListener mOnQRCodeReadListener;

	private static final String TAG = QRCodeReaderView.class.getName();

	private QRCodeReader mQRCodeReader;
	private int mPreviewWidth;
	private int mPreviewHeight;
	private SurfaceHolder mHolder;
	private CameraManager mCameraManager;

	public QRCodeReaderView(Context context) {
		super(context);
		handler.sendEmptyMessage(1);
		init();
	}

	public QRCodeReaderView(Context context, AttributeSet attrs) {

		super(context, attrs);
		handler.sendEmptyMessage(1);
		init();

	}

	public void setOnQRCodeReadListener(
			OnQRCodeReadListener onQRCodeReadListener) {
		mOnQRCodeReadListener = onQRCodeReadListener;
	}

	public CameraManager getCameraManager() {
		return mCameraManager;
	}

	@SuppressWarnings("deprecation")
	private void init() {
		if (checkCameraHardware(getContext())) {
			mCameraManager = new CameraManager(getContext());

			mHolder = this.getHolder();
			mHolder.addCallback(this);
			mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS); // Need to
																		// set
																		// this
																		// flag
																		// despite
																		// it's
																		// deprecated
		} else {
			Log.e(TAG, "Error: Camera not found");
			if (mOnQRCodeReadListener != null) {
				mOnQRCodeReadListener.cameraNotFound();
			}
		}
	}

	/****************************************************
	 * SurfaceHolder.Callback,Camera.PreviewCallback
	 ****************************************************/

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			// Indicate camera, our View dimensions打开相机驱动
			mCameraManager
					.openDriver(holder, this.getWidth(), this.getHeight());
		} catch (IOException e) {
			Log.w(TAG, "Can not openDriver: " + e.getMessage());
			mCameraManager.closeDriver();
		}

		try {
			mQRCodeReader = new QRCodeReader();// 相机开始烧苗
			mCameraManager.startPreview();

		} catch (Exception e) {
			Log.e(TAG, "Exception: " + e.getMessage());
			mCameraManager.closeDriver();
		}
		//handler.sendEmptyMessageDelayed(1, 60);
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.d(TAG, "surfaceDestroyed");
		mCameraManager.getCamera().setPreviewCallback(null);
		mCameraManager.getCamera().stopPreview();
		mCameraManager.getCamera().release();
		mCameraManager.closeDriver();
	}

	// Called when camera take a frame
	// 获取到相机捕获的图像
	@Override
	public void onPreviewFrame(byte[] data, Camera camera) {

		PlanarYUVLuminanceSource source = mCameraManager.buildLuminanceSource(
				data, mPreviewWidth, mPreviewHeight);

		HybridBinarizer hybBin = new HybridBinarizer(source);
		// 获取图像
		BinaryBitmap bitmap = new BinaryBitmap(hybBin);

		try {
			// 解析图像
			Result result = mQRCodeReader.decode(bitmap);

			// Notify we found a QRCode
			if (mOnQRCodeReadListener != null) {
				// Transform resultPoints to View coordinates
				PointF[] transformedPoints = transformToViewCoordinates(result
						.getResultPoints());
				mOnQRCodeReadListener.onQRCodeRead(result.getText(),
						transformedPoints);
			}

		} catch (ChecksumException e) {
			Log.d(TAG, "ChecksumException");
			e.printStackTrace();
		} catch (NotFoundException e) {
			// Notify QR not found
			if (mOnQRCodeReadListener != null) {
				mOnQRCodeReadListener.QRCodeNotFoundOnCamImage();
			}
		} catch (FormatException e) {
			Log.d(TAG, "FormatException");
			e.printStackTrace();
		} finally {
			mQRCodeReader.reset();
		}
	}

	@SuppressLint("NewApi")
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.d(TAG, "surfaceChanged");

		if (mHolder.getSurface() == null) {
			Log.e(TAG, "Error: preview surface does not exist");
			return;
		}

		// preview_width = width;
		// preview_height = height;

		mPreviewWidth = mCameraManager.getPreviewSize().x;
		mPreviewHeight = mCameraManager.getPreviewSize().y;

		mCameraManager.stopPreview();
		mCameraManager.getCamera().setPreviewCallback(this);
		mCameraManager.getCamera().setDisplayOrientation(90); // Portrait mode

		// Fix the camera sensor rotation
		setCameraDisplayOrientation(this.getContext(),
				mCameraManager.getCamera());

		mCameraManager.startPreview();
	}

	/**
	 * Transform result to surfaceView coordinates
	 * 
	 * This method is needed because coordinates are given in landscape camera
	 * coordinates. Now is working but transform operations aren't very
	 * explained
	 * 
	 * TODO re-write this method explaining each single value
	 * 
	 * @return a new PointF array with transformed points
	 */
	private PointF[] transformToViewCoordinates(ResultPoint[] resultPoints) {

		PointF[] transformedPoints = new PointF[resultPoints.length];
		int index = 0;
		if (resultPoints != null) {
			float previewX = mCameraManager.getPreviewSize().x;
			float previewY = mCameraManager.getPreviewSize().y;
			float scaleX = this.getWidth() / previewY;
			float scaleY = this.getHeight() / previewX;

			for (ResultPoint point : resultPoints) {
				PointF tmppoint = new PointF(
						(previewY - point.getY()) * scaleX, point.getX()
								* scaleY);
				transformedPoints[index] = tmppoint;
				index++;
			}
		}
		return transformedPoints;

	}

	/** Check if this device has a camera */
	@TargetApi(Build.VERSION_CODES.ECLAIR)
	@SuppressLint("NewApi")
	private boolean checkCameraHardware(Context context) {
		if (context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA)) {
			// this device has a camera
			return true;
		} else if (context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA_FRONT)) {
			// this device has a front camera
			return true;
		} else if (context.getPackageManager().hasSystemFeature(
				PackageManager.FEATURE_CAMERA_ANY)) {
			// this device has any camera
			return true;
		} else {
			// no camera on this device
			return false;
		}
	}

	/**
	 * Fix for the camera Sensor no some devices (ex.: Nexus 5x)
	 * http://developer
	 * .android.com/intl/pt-br/reference/android/hardware/Camera.
	 * html#setDisplayOrientation(int)
	 */
	@TargetApi(Build.VERSION_CODES.FROYO)
	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	public static void setCameraDisplayOrientation(Context context,
			android.hardware.Camera camera) {
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.GINGERBREAD) {
			Camera.CameraInfo info = new Camera.CameraInfo();
			android.hardware.Camera.getCameraInfo(0, info);
			WindowManager windowManager = (WindowManager) context
					.getSystemService(Context.WINDOW_SERVICE);
			int rotation = windowManager.getDefaultDisplay().getRotation();
			int degrees = 0;
			switch (rotation) {
			case Surface.ROTATION_0:
				degrees = 0;
				break;
			case Surface.ROTATION_90:
				degrees = 90;
				break;
			case Surface.ROTATION_180:
				degrees = 180;
				break;
			case Surface.ROTATION_270:
				degrees = 270;
				break;
			}

			int result;
			if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
				result = (info.orientation + degrees) % 360;
				result = (360 - result) % 360; // compensate the mirror
			} else { // back-facing
				result = (info.orientation - degrees + 360) % 360;
			}
			camera.setDisplayOrientation(result);
		}
	}

	private float heights = getHeight() / 5;
	private float Y = 0;
	Paint paint = new Paint();
	Matrix matrix = new Matrix();

	Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
			R.drawable.red_line);

	/*
	 * 画扫描线
	 */
	public void draw() {

		new Thread(new Runnable() {

			@Override
			public void run() {
				Canvas canvas = null;
				// TODO Auto-generated method stub
				try {
					canvas = mHolder.lockCanvas();
					float b[] = new float[9];
					matrix.getValues(b);

					for (int i = 0; i < 6;) {
						// 打印坐标
						Log.i("matrix", b[i] + "  " + b[i++] + "  " + b[i++]);

					}
					matrix.postTranslate(0, 4);
					canvas.drawBitmap(bitmap, matrix, paint);
					canvas.drawLine(0, 0, 100, 100, paint);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					mHolder.unlockCanvasAndPost(canvas);
				}
			}
		}).start();

	}
}
