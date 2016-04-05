package com.zhangshun.activity;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jiangkaiquan.aplication.MyApplaication;
import com.zhangshun.keep_in_good_health.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class UploadToServerActivity extends Activity {

	private MyApplaication app;

	private TextView messageText;
	private Button uploadButton;

	int serverResponseCode = 0;
	ProgressDialog dialog = null;

	String upLoadServerUri = "http://192.168.11.241/index.php/home/api/uploading.php";

	private static final int RESULT_PICK_IMAGE = 1;
	private static final int RESULT_TAKE_IMAGE = 2;

	private static final String JPEG_FILE_PREFIX = "IMG_";
	private static final String JPEG_FILE_SUFFIX = ".jpg";

	private String mCurrentPhotoPath = null;
	private ImageView imageView;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload_to_server);

		Button pickPhotoButton = (Button) findViewById(R.id.pickPhotoButton);
		Button takePhotoButton = (Button) findViewById(R.id.takePhotoButton);

		imageView = (ImageView) findViewById(R.id.imageView);

		uploadButton = (Button) findViewById(R.id.uploadButton);

		// takeButton = (Button) findViewById(R.id.takeButton);

		// 相册选取图片
		pickPhotoButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent takePhotoIntent = new Intent(Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(takePhotoIntent, RESULT_PICK_IMAGE);
			}
		});

		// 拍照选取图片
		takePhotoButton.setOnClickListener(new View.OnClickListener() {

			@SuppressLint("InlinedApi")
			@Override
			public void onClick(View arg0) {
				// 调用相机
				Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

				File f = null;
				try {
					f = setUpPhotoFile();
					mCurrentPhotoPath = f.getAbsolutePath();
					Log.d("path", mCurrentPhotoPath);

					takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
				} catch (IOException e) {
					e.printStackTrace();
					f = null;
					mCurrentPhotoPath = null;
				}

				startActivityForResult(takePictureIntent, RESULT_TAKE_IMAGE);
			}
		});

		uploadButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mCurrentPhotoPath != null) {
					// uploadFile(mCurrentPhotoPath, upLoadServerUri);
					new FileUploadTask(mCurrentPhotoPath, upLoadServerUri).execute();
				}
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (resultCode == Activity.RESULT_OK) {
			switch (requestCode) {
			case RESULT_PICK_IMAGE: {
				handlePickImage(data);
			}
				break;
			case RESULT_TAKE_IMAGE: {
				handleTakeImage();
			}
				break;
			default:
				break;

			}
		}
	}

	/**
	 * Handle a picture from picking
	 *
	 * @param intent
	 */
	private void handlePickImage(Intent intent) {
		Uri selectedImage = intent.getData();
		String[] filePathColumn = { MediaStore.Images.Media.DATA };

		Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
		cursor.moveToFirst();

		int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
		String picturePath = cursor.getString(columnIndex);
		cursor.close();

		setPic(imageView, picturePath);
		mCurrentPhotoPath = picturePath;
	}

	/**
	 * Handle a picture from taking
	 */
	private void handleTakeImage() {
		if (mCurrentPhotoPath != null) {
			setPic(imageView, mCurrentPhotoPath);
			galleryAddPic(mCurrentPhotoPath);
			mCurrentPhotoPath = null;
		}
	}

	/**
	 * Add a picture from taking to Gallery
	 *
	 * @param srcPath
	 */
	private void galleryAddPic(String srcPath) {
		Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
		File f = new File(srcPath);
		Uri contentUri = Uri.fromFile(f);
		mediaScanIntent.setData(contentUri);
		this.sendBroadcast(mediaScanIntent);
	}

	public String getAlbumName() {
		return "CameraSample";
	}

	@TargetApi(Build.VERSION_CODES.FROYO)

	@SuppressLint("NewApi")
	public File getAlbumStorageDir(String albumName) {
		return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), albumName);
	}

	private File getAlbumDir() {
		File storageDir = null;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			storageDir = getAlbumStorageDir(getAlbumName());
			if (storageDir != null) {
				if (!storageDir.mkdirs()) {
					if (!storageDir.exists()) {
						Log.d("CameraSample", "failed to create directory");
						return null;
					}
				}
			}

		} else {
			Log.v(getString(R.string.app_name), "External storage is not mounted READ/WRITE.");
		}

		return storageDir;
	}

	private File createImageFile() throws IOException {
		// Create an image file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
		File albumF = getAlbumDir();
		File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
		return imageF;
	}

	private File setUpPhotoFile() throws IOException {

		File f = createImageFile();
		mCurrentPhotoPath = f.getAbsolutePath();

		return f;
	}

	/**
	 * There isn't enough memory to open up more than a couple camera photos So
	 * pre-scale the target bitmap into which the file is decoded
	 * 
	 * @param mImageView
	 * @param srcPath
	 *            本地地址
	 */
	@SuppressLint("NewApi")
	private void setPic(ImageView mImageView, String srcPath) {
		/* Get the size of the ImageView */
		int targetW = mImageView.getWidth();
		int targetH = mImageView.getHeight();

		/* Get the size of the image */
		BitmapFactory.Options bmOptions = new BitmapFactory.Options();
		bmOptions.inJustDecodeBounds = true;
		BitmapFactory.decodeFile(srcPath, bmOptions);
		int photoW = bmOptions.outWidth;
		int photoH = bmOptions.outHeight;

		/* Figure out which way needs to be reduced less */
		int scaleFactor = 2;
		if ((targetW > 0) || (targetH > 0)) {
			scaleFactor = Math.min(photoW / targetW, photoH / targetH);
		}

		/* Set bitmap options to scale the image decode target */
		bmOptions.inJustDecodeBounds = false;
		bmOptions.inSampleSize = scaleFactor;
		bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */// 获取到的图片
		Bitmap bitmap = BitmapFactory.decodeFile(srcPath, bmOptions);
		app.user.setUserImg(bitmap);
		/* Associate the Bitmap to the ImageView */
		mImageView.setImageBitmap(bitmap);
	}

	/**
	 * 上传图片
	 * 
	 * @param //图片路径
	 * @param uploadUrl
	 *            上传
	 * @return
	 */
	public int uploadFile(final String fileUrl, String uploadUrl) {

		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);

		HttpURLConnection conn = null;
		DataOutputStream dos = null;
		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";
		int bytesRead, bytesAvailable, bufferSize;
		byte[] buffer;
		int maxBufferSize = 1 * 1024 * 1024;
		File sourceFile = new File(fileUrl);

		if (!sourceFile.isFile()) {
			dialog.dismiss();

			runOnUiThread(new Runnable() {

				public void run() {
					messageText.setText("Source File not exist :" + fileUrl);
				}
			});

			return 0;
		}
		try {

			// open a URL connection to the Servlet
			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			URL url = new URL(uploadUrl);

			// Open a HTTP connection to the URL
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true); // Allow Inputs
			conn.setDoOutput(true); // Allow Outputs
			conn.setUseCaches(false); // Don't use a Cached Copy
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("ENCTYPE", "multipart/form-data");
			conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			conn.setRequestProperty("uploaded_file", fileName);

			dos = new DataOutputStream(conn.getOutputStream());

			dos.writeBytes(twoHyphens + boundary + lineEnd);
			dos.writeBytes(
					"Content-Disposition: form-data; name=\"uploaded_file\";filename=\"" + fileName + "\"" + lineEnd);

			dos.writeBytes(lineEnd);

			// create a buffer of maximum size
			bytesAvailable = fileInputStream.available();

			bufferSize = Math.min(bytesAvailable, maxBufferSize);
			buffer = new byte[bufferSize];

			// read file and write it into form...
			bytesRead = fileInputStream.read(buffer, 0, bufferSize);

			while (bytesRead > 0) {

				dos.write(buffer, 0, bufferSize);
				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);

			}

			// send multipart form data necesssary after file data...
			dos.writeBytes(lineEnd);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

			// Responses from the server (code and message)
			serverResponseCode = conn.getResponseCode();
			String serverResponseMessage = conn.getResponseMessage();

			Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);

			if (serverResponseCode == 200) {
				runOnUiThread(new Runnable() {

					public void run() {
						Toast.makeText(UploadToServerActivity.this, "File Upload Complete.", Toast.LENGTH_SHORT).show();
					}
				});
			}
			// close the streams //
			fileInputStream.close();
			dos.flush();
			dos.close();

		} catch (MalformedURLException ex) {

			dialog.dismiss();
			ex.printStackTrace();

			runOnUiThread(new Runnable() {
				public void run() {
					messageText.setText("MalformedURLException Exception : check script url.");
					Toast.makeText(UploadToServerActivity.this, "MalformedURLException", Toast.LENGTH_SHORT).show();
				}
			});

			Log.e("Upload file to server", "error: " + ex.getMessage(), ex);
		} catch (Exception e) {

			dialog.dismiss();
			e.printStackTrace();

			runOnUiThread(new Runnable() {
				public void run() {
					messageText.setText("Got Exception : see logcat ");
					Toast.makeText(UploadToServerActivity.this, "Got Exception : see logcat2 ", Toast.LENGTH_SHORT)
							.show();
				}
			});

		}
		dialog.dismiss();

		return serverResponseCode;
	}

	@SuppressLint("NewApi")
	class FileUploadTask extends AsyncTask<Object, Integer, String> {

		private ProgressDialog dialog = null;

		HttpURLConnection connection = null;
		DataOutputStream outputStream = null;
		DataInputStream inputStream = null;

		String lineEnd = "\r\n";
		String twoHyphens = "--";
		String boundary = "*****";

		// the file path to upload
		String pathToOurFile;

		// the server address to process uploaded file
		String urlServer;

		// File
		File uploadFile;

		// File totalSize
		long totalSize;

		public FileUploadTask(String pathToOurFile, String urlServer) {
			this.pathToOurFile = pathToOurFile;
			this.urlServer = urlServer;

			this.uploadFile = new File(pathToOurFile);
			this.totalSize = uploadFile.length(); // Get size of file, bytes
		}

		@Override
		protected void onPreExecute() {
			dialog = new ProgressDialog(UploadToServerActivity.this);
			dialog.setMessage("正在上传...");
			dialog.setIndeterminate(false);
			dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			dialog.setProgress(0);
			dialog.show();
		}

		@Override
		protected String doInBackground(Object... arg0) {

			long length = 0;
			int progress;
			int bytesRead, bytesAvailable, bufferSize;
			byte[] buffer;
			int maxBufferSize = 256 * 1024;// 256KB

			try {
				FileInputStream fileInputStream = new FileInputStream(new File(pathToOurFile));

				URL url = new URL(urlServer);
				connection = (HttpURLConnection) url.openConnection();

				// Set size of every block for post
				connection.setChunkedStreamingMode(256 * 1024);// 256KB

				// Allow Inputs & Outputs
				connection.setDoInput(true);
				connection.setDoOutput(true);
				connection.setUseCaches(false);

				// Enable POST method
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Connection", "Keep-Alive");
				connection.setRequestProperty("ENCTYPE", "multipart/form-data");
				connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
				connection.setRequestProperty("uploaded_file", pathToOurFile);

				outputStream = new DataOutputStream(connection.getOutputStream());
				outputStream.writeBytes(twoHyphens + boundary + lineEnd);
				outputStream.writeBytes("Content-Disposition: form-data; name=\" " + "uploaded_file" + "\";filename=\""
						+ pathToOurFile + "\"" + lineEnd);
				outputStream.writeBytes(lineEnd);

				bytesAvailable = fileInputStream.available();
				bufferSize = Math.min(bytesAvailable, maxBufferSize);
				buffer = new byte[bufferSize];

				// Read file
				bytesRead = fileInputStream.read(buffer, 0, bufferSize);

				while (bytesRead > 0) {
					outputStream.write(buffer, 0, bufferSize);
					length += bufferSize;
					progress = (int) ((length * 100) / totalSize);
					publishProgress(progress);

					bytesAvailable = fileInputStream.available();
					bufferSize = Math.min(bytesAvailable, maxBufferSize);
					bytesRead = fileInputStream.read(buffer, 0, bufferSize);
				}
				outputStream.writeBytes(lineEnd);
				outputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
				publishProgress(100);

				// Responses from the server (code and message)
				int serverResponseCode = connection.getResponseCode();
				String serverResponseMessage = connection.getResponseMessage();

				InputStream is = connection.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String result = br.readLine();

				fileInputStream.close();
				outputStream.flush();
				outputStream.close();

				return result;
			} catch (Exception ex) {
				return "网络异常，上传失败";
			}
		}

		@Override
		protected void onProgressUpdate(Integer... progress) {
			dialog.setProgress(progress[0]);
		}

		@Override
		protected void onPostExecute(final String result) {

			if (dialog != null) {
				dialog.dismiss();
				// ShowTip.showTip(UserSignActivity.this, windowManager, view);
			}
			super.onPostExecute(result);
		}
	}
}