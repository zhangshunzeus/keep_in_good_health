package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class ForgetPasswordActivity extends Activity {

	Button forget_finish;
	ImageView myrecords_return_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forget_password);

		forget_finish = (Button) findViewById(R.id.forget_finish);
		forget_finish.setOnClickListener(click);
		myrecords_return_btn = (ImageView) findViewById(R.id.myrecords_return_btn);
		myrecords_return_btn.setOnClickListener(click);
	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.forget_finish:
				finish();
				break;
			case R.id.myrecords_return_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};

}
