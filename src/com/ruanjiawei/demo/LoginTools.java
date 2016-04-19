package com.ruanjiawei.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.jiangkaiquan.aplication.MyApplaication;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

public class LoginTools {

	public static String HTTP_HOST = "http://211.149.198.8:9803/index.php/home/api/";
	public static String LOGIN_URL = "login";
	String login;
	String message;

	public int status = 0;

	public void loginAccount(String tel, String password) {
		new AnyTask().execute(tel, password);
	}

	private String postconn(String tel, String password) {

		StringBuilder builder = new StringBuilder(); // 初始化一个Stringbuilder
		String httpHost = "http://211.149.198.8:9803/index.php/home/api/login";
		String urltel = "tel=";
		String passwordkey = "password=";

		URL url;
		try {
			String urlName = httpHost + "?" + urltel + tel + "&" + passwordkey
					+ password; // url资源地址
			url = new URL(urlName);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			connection.setRequestMethod("GET");
			connection.setReadTimeout(5000);
			connection.connect();

			if (connection.getResponseCode() == 200) {
				InputStream inputStream = connection.getInputStream();
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(inputStream));
				String line = bufferedReader.readLine();
				while (line != null && line.length() > 0) {
					builder.append(line);
					line = bufferedReader.readLine(); // 读取出来
					login = builder.toString();
				}

				inputStream.close();
				bufferedReader.close();

				login = builder.toString();
				Log.i("LoginTools====>用户信息", login);
				return login;
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "error";

	}

	OnHttpListener mListener;

	@SuppressLint("NewApi")
	public void setOnHttpListener(OnHttpListener mListener) {
		this.mListener = mListener;
	}

	@TargetApi(Build.VERSION_CODES.CUPCAKE)
	class AnyTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {

			return postconn(arg0[0], arg0[1]);
		}

		@Override
		protected void onPostExecute(String result) {
			if (mListener != null) {
				mListener.end(result);
			}
		}
	}

	public interface OnHttpListener {
		void start();

		// 获取用户登录后的信息
		void end(String result);

	}

	public String getMessage() {

		return message;
	}

}
