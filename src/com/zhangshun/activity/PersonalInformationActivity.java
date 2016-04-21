package com.zhangshun.activity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.jiangkaiquan.aplication.MyApplaication;
import com.jiangkaiquan.aplication.User;
import com.ruanjiawei.demo.LogoutTools;
import com.ruanjiawei.demo.SaveToken;
import com.ruanjiawei.demo.LogoutTools.OnLogoutListener;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterNotLogin;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
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

	protected static final int PHOTO_REQUEST_TAKEPHOTO = 0;
	protected static final int PHOTO_REQUEST_GALLERY = 0;
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
	TextView username_text;
	String tel;
	String token;
	String info;
	String username;

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

		token = SaveToken.getData(getApplicationContext());
		tel = SaveToken.getTels(getApplicationContext());

		demand(tel, token);
	}

	@SuppressWarnings("unused")
	private void demand(String tel, String token) {
		StringBuilder builder = new StringBuilder();
		String httpHost = "http://211.149.198.8:9803/index.php/home/api/demand";
		String urltel = "tel=";
		String urltoken = "token=";

		URL url;

		try {
			String urllogout = httpHost + "?" + urltel + tel + "&" + urltoken
					+ token;
			url = new URL(urllogout);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			connection.setRequestMethod("GET");
			connection.setReadTimeout(5000);
			connection.connect();

			if (connection.getResponseCode() == 200) {
				InputStream inputStream = connection.getInputStream();
				BufferedReader buffered = new BufferedReader(
						new InputStreamReader(inputStream));
				String line = buffered.readLine();
				while (line != null && line.length() > 0) {
					builder.append(line);
					line = buffered.readLine();

				}
				inputStream.close();
				buffered.close();

				// Log.i("sfsf", buffered.toString());
				info = builder.toString();
				Log.i("信息", info);
				JSONObject js = new JSONObject(info);
				String name = js.getString("message");
				Log.i("message", name);

				JSONObject json = new JSONObject(name);
				json.getString("username");

				username_text = (TextView) findViewById(R.id.username_text);
				username_text.setText(json.getString("username"));
				Log.i("name", json.getString("username"));

			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

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
					// username_text = (TextView)
					// findViewById(R.id.username_text);
					// username_text.setText(js.getString("username"));
					Log.i("nusrname", js.getString("username"));
				} else {
					Toast.makeText(getApplicationContext(),
							js.getString("message"), Toast.LENGTH_LONG).show();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	};

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			switch (v.getId()) {
			case R.id.return_btn:
				finish();
				break;
			case R.id.dialog_head_portrait: // 头像
				showDialog();
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

				Intent intent = new Intent(PersonalInformationActivity.this,
						PersonalCenterNotLogin.class);
				startActivity(intent);

				break;
			default:
				break;
			}
		}
	};

	/**
	 * 点击修改头像
	 * */
	public void showDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("头像设置");
		builder.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

			private File tempFile;

			@TargetApi(Build.VERSION_CODES.CUPCAKE)
			@SuppressLint("InlinedApi")
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				// 调用系统的拍照功能
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// 指定调用相机拍照后照片的储存路径
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
				startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
			}
		});
		builder.setNegativeButton("相册", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.dismiss();
				Intent intent = new Intent(Intent.ACTION_PICK, null);
				intent.setDataAndType(
						MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
				startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
			}
		}).show();

	}

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
