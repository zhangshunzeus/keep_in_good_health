package com.jiangkaiquan.view;

import com.zhangshun.keep_in_good_health.R;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 关于matrix 应用的类，matrix 使用前要set一下，再用pre 和post
 * 
 * @author jkqme
 * 
 */
public class MyView extends android.view.View {

	private Handler handler = new Handler() {
		// 自定义类的局部变量
		int i = 70;

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub

			//Log.i("MyviewHander", heights + "");
			if (i == 70) {
				matrix.setTranslate(0, 0);
				i = 1;
			}
			i++;
			invalidate();
			sendEmptyMessageDelayed(1, 60);
		}
	};
	private float heights;
	private float Y = 0;
	Paint paint = new Paint();
	Matrix matrix = new Matrix();

	Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
			R.drawable.red_line);

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		// matrix.setTranslate(0, 0);
		// Log.i("Myview", "" + heights);

		handler.sendEmptyMessage(1);
	}

	@Override
	public void draw(Canvas canvas) {
		// TODO Auto-generated method stub

		// matrix.postTranslate(0, heights);
		float b[] = new float[9];
		matrix.getValues(b);

		for (int i = 0; i < 6;) {

			//Log.i("matrix", b[i] + "  " + b[i++] + "  " + b[i++]);

		}
		matrix.postTranslate(0, 4);
		canvas.drawBitmap(bitmap, matrix, paint);

	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub

		heights = MeasureSpec.getMode(heightMeasureSpec) / 5;
		//Log.i("ONMeasure", heights + "    " + heightMeasureSpec);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}
