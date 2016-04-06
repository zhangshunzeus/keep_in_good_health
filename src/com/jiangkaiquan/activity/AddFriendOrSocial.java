package com.jiangkaiquan.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.jiangkaiquan.activity.adapter.NetUrl;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 添加好友的页面，intent 从 origin 传来的extra要传回去要重设
 * 
 * @author jkqme
 * 
 */
public class AddFriendOrSocial extends Activity {
	private Intent intent;
	private EditText eText;
	private TextView tView;
	private boolean isFriend;
	private TextView titleTextView;

	private String ip = NetUrl.ip1;
	private String addDate = "addDate";
	private String addDates = "addDates";

	private String friend = "好友";
	private String social = "群";
	private String courrent;
	private Bundle bundle=new Bundle();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jiangkaiquan_addfriend);
		eText = (EditText) findViewById(R.id.addfriend_etx);
		tView = (TextView) findViewById(R.id.addfriend_tx);
		titleTextView = (TextView) findViewById(R.id.addfriend_title_tx);
		intent = getIntent();
		// 设置默认返回的intent；

		isFriend = intent.getBooleanExtra("isFriend", true);
		bundle.putBoolean("isFriend",isFriend);
		intent.putExtras(bundle);
		setResult(2, intent);

		eText.setOnClickListener(listener);
		tView.setOnClickListener(listener);
		if (isFriend) {
			tView.setText("添加" + friend);
			courrent = friend;
		} else {
			tView.setText("添加" + social);
			courrent = social;
		}
		titleTextView.setText("添加" + courrent);
	}

	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.addfriend_etx:
				// 改变编辑框焦点
				if (!eText.isFocusable()) {
					Log.i("Editex", "获取焦点");
					eText.setFocusable(true);
					eText.setFocusableInTouchMode(true);
					eText.requestFocus();
				}
				break;
			case R.id.addfriend_tx:
				whenClickAdd();
				break;

			default:
				break;
			}
		}
	};

	/**
	 * 点击添加时的方法
	 */
	private void whenClickAdd() {
		String username = eText.getText().toString();
		Log.i("getEdit", username);
		if (username != null && username != "") {
			// 添加成功时的返回
			// setResult(2, intent);
			if (isFriend) {
				getDateByHttpConnection(ip + NetUrl.friend + addDate + "?"
						+ "key=" + username + "&" + "menber=defult");
			} else {
				getDateByHttpConnection(ip + NetUrl.friend + addDates + "?"
						+ "key=" + username + "&" + "menber=defult");
			}
		} else {
			Toast.makeText(this, "没有输入" + courrent + "名", 1500);
		}

	}

	public void getDateByHttpConnection(String urls) {
		final StringBuilder sBuilder = new StringBuilder();

		final String url = urls;

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					HttpURLConnection connection;
					URL mUrl = new URL(url);
					connection = (HttpURLConnection) mUrl.openConnection();

					connection.setReadTimeout(5000);
					connection.setConnectTimeout(5000);
					connection.setRequestMethod("GET");
					try {
						connection.connect();
					} catch (ConnectException e) {
						disMessage("网络故障");
						return;
					}
					BufferedReader reader = new BufferedReader(
							new InputStreamReader(connection.getInputStream()));
					if (connection.getResponseCode() == 200) {
						String line = reader.readLine();
						while (line != null && line.length() > 0) {
							sBuilder.append(line);
							line = reader.readLine();

						}
						// 添加成功提示
						disMessage("添加成功");

						finish();

					} else {
						Log.i("getDateByHttpConnection", "you havn't connete");
					}
					reader.close();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}).start();
	}

	private void disMessage(String a) {
		final String bString=a;
		this.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Toast.makeText(AddFriendOrSocial.this,bString, 1500).show();
			}
		});
		

	}
}
