package com.zhangshun.activity;

import org.json.JSONException;
import org.json.JSONObject;

import com.jiangkaiquan.aplication.MyApplaication;
import com.jiangkaiquan.aplication.User;
import com.ruanjiawei.demo.LogoutTools;
import com.ruanjiawei.demo.SaveToken;
import com.ruanjiawei.demo.LogoutTools.OnLogoutListener;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterNotLogin;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PersonalInformationActivity extends Activity {

	MyApplaication app;
	ImageView return_btn;// 返回按钮
	LinearLayout dialog_head_portrait;// 头像
	LinearLayout dialog_username_text;// 昵称
	LinearLayout dialog_log_in_the_phone;// 登陆手机
	LinearLayout dialog_the_login_password;// 登陆密码
	LinearLayout dialog_binding_wechat_id;// 绑定微信号
	LinearLayout dialog_binding_qq_number;// 绑定QQ
	LinearLayout dialog_the_binding_of_sina_weibo;// 绑定新浪微博
	LinearLayout dialog_binding_alipay;// 绑定支付宝
	Button btn_exit;// 退出
	LogoutTools logout;

	// 个人信息页面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_information);
		app = (MyApplaication) getApplication();

		return_btn = (ImageView) findViewById(R.id.return_btn);
		dialog_head_portrait = (LinearLayout) findViewById(R.id.dialog_head_portrait);
		dialog_username_text = (LinearLayout) findViewById(R.id.dialog_username_text);
		dialog_log_in_the_phone = (LinearLayout) findViewById(R.id.dialog_log_in_the_phone);
		dialog_the_login_password = (LinearLayout) findViewById(R.id.dialog_the_login_password);
		dialog_binding_wechat_id = (LinearLayout) findViewById(R.id.dialog_binding_wechat_id);
		dialog_binding_qq_number = (LinearLayout) findViewById(R.id.dialog_binding_qq_number);
		dialog_the_binding_of_sina_weibo = (LinearLayout) findViewById(R.id.dialog_the_binding_of_sina_weibo);
		dialog_binding_alipay = (LinearLayout) findViewById(R.id.dialog_binding_alipay);
		btn_exit = (Button) findViewById(R.id.btn_exit);

		return_btn.setOnClickListener(click);
		dialog_head_portrait.setOnClickListener(click);
		dialog_username_text.setOnClickListener(click);
		dialog_log_in_the_phone.setOnClickListener(click);
		dialog_the_login_password.setOnClickListener(click);
		dialog_binding_wechat_id.setOnClickListener(click);
		dialog_binding_qq_number.setOnClickListener(click);
		dialog_the_binding_of_sina_weibo.setOnClickListener(click);
		dialog_binding_alipay.setOnClickListener(click);
		btn_exit.setOnClickListener(click);

	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			OnLogoutListener mlistener = new OnLogoutListener() {

				@Override
				public void start() {
					// TODO Auto-generated method stub

				}

				@Override
				public void end(String result) {
					try {
						JSONObject js = new JSONObject(result);

						if (js.getInt("status") == 1) {
							Intent intent = new Intent(
									PersonalInformationActivity.this,
									PersonalCenterNotLogin.class);

							startActivity(intent);
						}else{
							Toast.makeText(getApplication(),
									js.getString("message"), Toast.LENGTH_LONG)
									.show();
						}

					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			};

			switch (v.getId()) {
			case R.id.return_btn:
				finish();
				break;
			case R.id.dialog_head_portrait: // 头像
				Intent intent_uploadToServer = new Intent();
				intent_uploadToServer.setClass(
						PersonalInformationActivity.this,
						UploadToServerActivity.class);
				startActivity(intent_uploadToServer);
				break;
			case R.id.dialog_username_text: // 昵称
				dialog_username_text();
				break;
			case R.id.dialog_log_in_the_phone: // 登陆手机
				dialog_log_in_the_phone();
				break;
			case R.id.dialog_the_login_password: // 登陆密码
				dialog_the_login_password();
				break;
			case R.id.dialog_binding_wechat_id: // 绑定微信号
				dialog_binding_wechat_id();
				break;
			case R.id.dialog_binding_qq_number: // 绑定QQ
				dialog_binding_qq_number();
				break;
			case R.id.dialog_the_binding_of_sina_weibo: // 绑定新浪微博
				dialog_the_binding_of_sina_weibo();
				break;
			case R.id.dialog_binding_alipay: // 绑定支付宝
				dialog_binding_alipay();
				break;
			case R.id.btn_exit:
				
				Intent intent=new Intent(PersonalInformationActivity.this,PersonalCenterNotLogin.class);
				startActivity(intent);

				break;
			default:
				break;
			}
		}
	};

	/**
	 * 点击昵称 弹出Dialog 修改昵称
	 * */
	private void dialog_username_text() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_username_text, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入昵称")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_username_text);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.username_text);
						tv.setText(inputPwd);
						app.user.setUserName(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();
	}

	/**
	 * 修改登陆手机号
	 * */
	private void dialog_log_in_the_phone() {
		// 获取当前页
		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		// 获取输入页
		final View textEntryView = factory.inflate(
				R.layout.dialog_log_in_the_phone, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入手机号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// 实例化输入框
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_log_in_the_phone);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.log_in_the_phone_text);
						tv.setText(inputPwd);
						app.user.setPhoneNum(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();

	}

	/**
	 * 修改密码
	 * */
	private void dialog_the_login_password() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_the_login_password, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入手机号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_the_login_password);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.the_login_password_text);
						tv.setText(inputPwd);
						app.user.setPassword(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();
	}

	/**
	 * 绑定微信号
	 * */
	private void dialog_binding_wechat_id() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_binding_wechat_id, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入手机号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_binding_wechat_id);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.binding_weChat_ID_text);
						tv.setText(inputPwd);
						app.user.setVchar(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();

	}

	/**
	 * 绑定QQ
	 * */
	private void dialog_binding_qq_number() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_binding_qq_number, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入QQ号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_binding_qq_number);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.Binding_QQ_number_text);
						tv.setText(inputPwd);
						app.user.setQqNmber(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();

	}

	/**
	 * 绑定新浪微博
	 * */
	private void dialog_the_binding_of_sina_weibo() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_the_binding_of_sina_weibo, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入手机号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_the_binding_of_sina_weibo);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.The_binding_of_sina_weibo_text);
						tv.setText(inputPwd);
						app.user.setXinlangBind(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();

	}

	/**
	 * 绑定支付宝
	 * */

	private void dialog_binding_alipay() {

		LayoutInflater factory = LayoutInflater
				.from(PersonalInformationActivity.this);
		final View textEntryView = factory.inflate(
				R.layout.dialog_binding_alipay, null);
		AlertDialog dlg = new AlertDialog.Builder(
				PersonalInformationActivity.this)
				.setTitle("请输入手机号")
				.setView(textEntryView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						EditText secondPwd = (EditText) textEntryView
								.findViewById(R.id.edit_dialog_binding_alipay);
						String inputPwd = secondPwd.getText().toString();
						setTitle(inputPwd);
						TextView tv = (TextView) findViewById(R.id.Binding_alipay_text);
						tv.setText(inputPwd);
						app.user.setAlipayBind(inputPwd);
					}
				})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {

							}
						}).create();
		dlg.show();

	}

}
