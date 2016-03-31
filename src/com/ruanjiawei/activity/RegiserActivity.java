package com.ruanjiawei.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.jiangkaiquan.aplication.MyApplaication;
import com.ruanjiawei.demo.RegisterTools;
import com.ruanjiawei.demo.RegisterTools.OnHttpListener;
import com.ruanjiawei.demo.VerifyTools;
import com.ruanjiawei.demo.VerifyTools.OnverifyListener;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class RegiserActivity extends Activity {
	MyApplaication app;
	EditText register_tel, register_verify, register_word, register_reword;
	Button register_gainverify, register_finsh;
	ImageView back;

	String tel, verify, password, repassword;
	RegisterTools registerTools = new RegisterTools();
	VerifyTools verifyTools = new VerifyTools();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		app = (MyApplaication) getApplication();

		register_gainverify = (Button) findViewById(R.id.register_gainverify);
		register_gainverify.setOnClickListener(l);
		register_finsh = (Button) findViewById(R.id.register_finsh);
		register_finsh.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		// 注册
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
						Intent intent = new Intent(RegiserActivity.this,
								LoginActivity.class);
						startActivity(intent);

						Toast.makeText(getApplication(), "注册成功 请登录",
								Toast.LENGTH_LONG).show();
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

		// 获取验证码
		private OnverifyListener listener = new OnverifyListener() {

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

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.register_gainverify:
				register_tel = (EditText) findViewById(R.id.register_tel);

				tel = register_tel.getText().toString();
				if (tel == null || tel.equals("")) {
					Toast.makeText(getApplication(), "请输入手机号",
							Toast.LENGTH_LONG).show();
				} else {
					verifyTools.setOnverifyListener(listener);
					verifyTools.verifyAccount(tel);
				}

				break;

			case R.id.register_finsh:
				register_tel = (EditText) findViewById(R.id.register_tel);
				register_verify = (EditText) findViewById(R.id.register_verify);
				register_word = (EditText) findViewById(R.id.register_word);
				register_reword = (EditText) findViewById(R.id.register_reword);
				tel = register_tel.getText().toString();
				verify = register_verify.getText().toString();
				password = register_word.getText().toString();
				repassword = register_reword.getText().toString();
				if (tel == null || tel.equals("")) {
					Toast.makeText(getApplication(), "请输入手机号",
							Toast.LENGTH_LONG).show();
				} else {
					if (password == null || password.equals("")) {
						Toast.makeText(getApplication(), "请输入密码",
								Toast.LENGTH_LONG).show();
					} else {
						// 向app 推入数据
						app.user.setPhoneNum(tel);
						app.user.setPassword(password);
						registerTools.setOnHttpListener(mListener);
						registerTools.registerAccount(tel, verify, password,
								repassword);

					}
				}

				break;

			default:
				break;
			}
		}
	};
}
