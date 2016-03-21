package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity {
	TextView login_register,forget_password;
	ImageView login_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		login_register = (TextView) findViewById(R.id.login_register);
		
		forget_password = (TextView) findViewById (R.id.forget_password);
		forget_password.setOnClickListener(l);
		login_register.setOnClickListener(l);
		
		login_btn = (ImageView) findViewById (R.id.login_btn);
		login_btn.setOnClickListener(l);
		
	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login_register:
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, RegiserActivity.class);
				startActivity(intent);
				break;
			case R.id.forget_password:
				Intent intent_forget_password = new Intent();
				intent_forget_password.setClass(LoginActivity.this,ForgetPasswordActivity.class);
				startActivity(intent_forget_password);
				break;
			case R.id.login_btn:
				finish();
				break;
			default:
				break;
			}
		}
	};
}
