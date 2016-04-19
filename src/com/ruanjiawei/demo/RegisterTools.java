package com.ruanjiawei.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import android.annotation.SuppressLint;
import android.os.AsyncTask;

public class RegisterTools {

	String message;
	public int status = 0;

	public void registerAccount(String tel, String verify, String password,
			String repassword) {
		new AnyTask().execute(tel, verify, password, repassword);
	}

	private String register(String tel, String verify, String password,
			String repassword) {

		StringBuilder builder = new StringBuilder();
		String httpHost = "http://211.149.198.8:9803/index.php/home/api/register";

		String urltel = "tel=";
		String verifykey = "verify=";
		String passwordkey = "password=";
		String repasswordkey = "repassword=";

		URL url;
		// 注册地址

		try {
			String urlregister = httpHost + "?" + verifykey + verify + "&"
					+ urltel + tel + "&" + passwordkey + password + "&"
					+ repasswordkey + repassword;

			url = new URL(urlregister);
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
					line = bufferedReader.readLine();
				}
				inputStream.close();
				bufferedReader.close();
				return builder.toString();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";

	}

	// 验证码地址
	@SuppressWarnings("unused")
	private String setverify(String tel) {
		StringBuilder builder = new StringBuilder();
		String verifycode = "http://192.168.11.241/index.php/home/api/verify";
		String urltel = "tel=";

		URL url;

		try {
			String urlverify = verifycode + "?" + urltel + tel;
			url = new URL(urlverify);
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
					line = bufferedReader.toString();
				}
				return builder.toString();
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

	public void setOnHttpListener(OnHttpListener mListener) {
		this.mListener = mListener;
	}

	@SuppressLint("NewApi")
	class AnyTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {

			return register(arg0[0], arg0[1], arg0[2], arg0[3]);
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

		void end(String result);

	}

	public String getMessage() {

		return message;
	}

}
