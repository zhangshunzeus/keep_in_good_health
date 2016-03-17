package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ForgetPasswordActivity extends Activity {

	Button forget_finish;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forget_password);
		forget_finish = (Button) findViewById(R.id.forget_finish);

		forget_finish.setOnClickListener(click);
	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.forget_finish:
				Intent intent_forget_finish = new Intent();
				intent_forget_finish.setClass(ForgetPasswordActivity.this,
						LoginActivity.class);
				startActivity(intent_forget_finish);
				break;

			default:
				break;
			}
		}
	};

}
