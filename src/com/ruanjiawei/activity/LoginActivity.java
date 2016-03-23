package com.ruanjiawei.activity;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.ruanjiawei.demo.LoginTools;
import com.ruanjiawei.demo.LoginTools.OnHttpListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.UMAuthListener;
import com.umeng.socialize.controller.listener.SocializeListeners.UMDataListener;
import com.umeng.socialize.exception.SocializeException;
import com.umeng.socialize.sso.UMSsoHandler;
import com.umeng.soexample.commons.Constants;
import com.ruanjiawei.activity.LoginActivity;
import com.ruanjiawei.demo.SaveToken;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterNotLogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
	// 整个平台的Controller,负责管理整个SDK的配置、操作等处理
	private UMSocialService mController = UMServiceFactory
			.getUMSocialService(Constants.DESCRIPTOR);
	TextView login_register, forget_password;
	EditText login_tel, login_password;
	Button login_btn;
	ImageView myrecords_return_btn;
	String tel;
	String password;
	LoginTools logintools = new LoginTools();
	private ImageView sinaLoginButton;
	private ImageView qqLoginButton;
	private ImageView wechatLoginButton;
	
	SaveToken saveToken=new SaveToken();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		login_register = (TextView) findViewById(R.id.login_register);
		forget_password = (TextView) findViewById(R.id.forget_password);

		myrecords_return_btn = (ImageView) findViewById (R.id.myrecords_return_btn);
		sinaLoginButton = (ImageView) this.findViewById(R.id.btn_sina_login);
		qqLoginButton = (ImageView) this.findViewById(R.id.btn_qq_login);
		wechatLoginButton = (ImageView) this.findViewById(R.id.btn_wechat_login);
		sinaLoginButton.setOnClickListener(l);
		qqLoginButton.setOnClickListener(l);
		wechatLoginButton.setOnClickListener(l);
		myrecords_return_btn.setOnClickListener(l);
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
						saveToken.saveToken(getApplicationContext(), jo.getString("token"));
						Intent intent = new Intent(LoginActivity.this,
								PersonalCenterNotLogin.class);
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
				break;
			case R.id.myrecords_return_btn:
				finish();
				break;
				
			case R.id.btn_sina_login: // 新浪微博登录
				login(SHARE_MEDIA.SINA);
				break;
			case R.id.btn_qq_login: //  qq登录
				login(SHARE_MEDIA.QQ);
				break;
			case R.id.btn_wechat_login: // 微信登陆
				login(SHARE_MEDIA.WEIXIN);
				break;
				
			default:
				break;

			}
		}
	};
	
	/**
	 * 授权。如果授权成功，则获取用户信息
	 * 
	 * @param platform
	 */
	private void login(final SHARE_MEDIA platform) {
		mController.doOauthVerify(LoginActivity.this, platform,
				new UMAuthListener() {

					@Override
					public void onStart(SHARE_MEDIA platform) {
						Toast.makeText(LoginActivity.this, "授权开始",
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onError(SocializeException e,
							SHARE_MEDIA platform) {
						Toast.makeText(LoginActivity.this, "授权失败",
								Toast.LENGTH_SHORT).show();
					}

					@Override
					public void onComplete(Bundle value, SHARE_MEDIA platform) {
						// 获得uid
						String uid = value.getString("uid");
						if (!TextUtils.isEmpty(uid)) {
							// uid不为空，获取用户信息
							getUserInfo(platform);
						} else {
							Toast.makeText(LoginActivity.this, "授权失败...",
									Toast.LENGTH_LONG).show();
						}
					}

					@Override
					public void onCancel(SHARE_MEDIA platform) {
						Toast.makeText(LoginActivity.this, "授权取消",
								Toast.LENGTH_SHORT).show();
					}
				});
	}

	/**
	 * 获取用户信息
	 * 
	 * @param platform
	 */
	private void getUserInfo(SHARE_MEDIA platform) {
		mController.getPlatformInfo(LoginActivity.this, platform,
				new UMDataListener() {

					@Override
					public void onStart() {

					}

					@Override
					public void onComplete(int status, Map<String, Object> info) {

						if (info != null) {
							Toast.makeText(LoginActivity.this, info.toString(),
									Toast.LENGTH_SHORT).show();
						}
					}
				});
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// 根据requestCode获取对应的SsoHandler
		UMSsoHandler ssoHandler = mController.getConfig().getSsoHandler(
				resultCode);
		if (ssoHandler != null) {
			ssoHandler.authorizeCallBack(requestCode, resultCode, data);
		}
	}
	
	
	
}

