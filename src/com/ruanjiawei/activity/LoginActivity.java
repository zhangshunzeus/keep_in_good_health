package com.ruanjiawei.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.ruanjiawei.demo.LoginTools;
import com.ruanjiawei.demo.LoginTools.OnHttpListener;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	TextView login_register, forget_password;
	EditText login_tel, login_password;
	Button login_btn;

	String tel;
	String password;
	LoginTools logintools = new LoginTools();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		login_register = (TextView) findViewById(R.id.login_register);

		forget_password = (TextView) findViewById(R.id.forget_password);
		forget_password.setOnClickListener(l);
		login_register.setOnClickListener(l);

		login_btn = (Button) findViewById(R.id.login_btn);
		login_btn.setOnClickListener(l);
	}

	OnClickListener l = new OnClickListener() {

		private OnHttpListener mListener = new OnHttpListener() {

			@Override
			public void start() {
				// TODO Auto-generated method stub

			}

			@Override
			public void end(String result) {
				// TODO Auto-generated method stub
				try {
					JSONObject jo = new JSONObject(result);
					if (jo.getInt("status") == 1) {
						Intent intent = new Intent(LoginActivity.this,
								MoreActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplication(),
								jo.getString("message"), Toast.LENGTH_LONG)
								.show();
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.login_register:
				intent.setClass(LoginActivity.this, RegiserActivity.class);
				startActivity(intent);
				break;
			case R.id.forget_password:
				Intent intent_forget_password = new Intent();
				intent_forget_password.setClass(LoginActivity.this,
						ForgetPasswordActivity.class);
				startActivity(intent_forget_password);
				break;
			case R.id.login_btn:
				login_tel = (EditText) findViewById(R.id.login_tel);
				login_password = (EditText) findViewById(R.id.login_password);
				tel = login_tel.getText().toString();
				password = login_password.getText().toString();

				logintools.setOnHttpListener(mListener);
				logintools.loginAccount(tel, password);

				/*
				 * intent.setClass(LoginActivity.this,MoreActivity.class);
				 * startActivity(intent);
				 */
				break;
			default:
				break;

			}
		}
	};
}
