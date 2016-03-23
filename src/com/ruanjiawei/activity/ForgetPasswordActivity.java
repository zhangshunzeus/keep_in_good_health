package com.ruanjiawei.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.ruanjiawei.demo.ForgetPasswordTools;
import com.ruanjiawei.demo.ForgetPasswordTools.OnForgetPasswordListener;
import com.ruanjiawei.demo.VerifyTools.OnverifyListener;
import com.ruanjiawei.demo.VerifyTools;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class ForgetPasswordActivity extends Activity {

	ImageView finsh;
	Button forget_finish, getverify;
	EditText forget_tel, forget_verify, forget_password, forget_repassword;
	ForgetPasswordTools tools = new ForgetPasswordTools();
	VerifyTools verfyTools = new VerifyTools();
	String tel, verify, password, repassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forget_password);
		forget_finish = (Button) findViewById(R.id.forget_finish);
		forget_finish.setOnClickListener(click);
		getverify = (Button) findViewById(R.id.getverify);
		getverify.setOnClickListener(click);
		finsh=(ImageView) findViewById(R.id.finsh);
		finsh.setOnClickListener(click);
	}

	OnClickListener click = new OnClickListener() {

		// 获取验证码

		private OnverifyListener mlistener = new OnverifyListener() {

			@Override
			public void start() {
				// TODO Auto-generated method stub

			}

			@Override
			public void end(String result) {
				// TODO Auto-generated method stub
				try {

					JSONObject jo = new JSONObject(result);
					Toast.makeText(getApplication(),
							"验证码：" + jo.getString("verify"), Toast.LENGTH_LONG)
							.show();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.i("验证码", result);
			}

		};

		// 修改密码
		private OnForgetPasswordListener listener = new OnForgetPasswordListener() {

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
						Intent intent = new Intent(ForgetPasswordActivity.this,
								LoginActivity.class);
						startActivity(intent);
					} else {
						Toast.makeText(getApplicationContext(),
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
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.getverify:
				forget_tel = (EditText) findViewById(R.id.forget_tel);

				tel = forget_tel.getText().toString();

				if (tel == null && tel == " ") {
					Toast.makeText(getApplication(), "请输入手机号",
							Toast.LENGTH_LONG).show();
				} else {
					verfyTools.setOnverifyListener(mlistener);
					verfyTools.verifyAccount(tel);
				}

				break;
			case R.id.forget_finish:
				forget_tel = (EditText) findViewById(R.id.forget_tel);
				forget_verify = (EditText) findViewById(R.id.forget_verify);
				forget_password = (EditText) findViewById(R.id.forget_password);
				forget_repassword = (EditText) findViewById(R.id.forget_repassword);

				tel = forget_tel.getText().toString();
				verify = forget_verify.getText().toString();
				password = forget_password.getText().toString();
				repassword = forget_repassword.getText().toString();
				
				tools.setOnForgetPasswordListener(listener);
				tools.forgerpasswordAccount(tel, verify, password, repassword);
				
				break;
			case R.id.finsh:
				finish();
				break;
		

			default:
				break;
			}
		}
	};

}
