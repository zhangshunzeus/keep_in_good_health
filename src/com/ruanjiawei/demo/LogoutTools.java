package com.ruanjiawei.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.annotation.SuppressLint;
import android.os.AsyncTask;

public class LogoutTools {
	String message;
	public int status = 0;

	private String logout(String tel, String token) {
		StringBuilder builder = new StringBuilder();
		String httpHost = "http://192.168.11.241/index.php/home/api/logout";
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
					line = buffered.toString();
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

	OnLogoutListener listener;

	public void setOnLogoutListener(OnLogoutListener listener) {
		this.listener = listener;
	}

	public interface OnLogoutListener {
		void start();

		void end(String result);
	}

	public String getMessage() {
		return message;
	}

	@SuppressLint("NewApi")
	class AnyTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return logout(arg0[0], arg0[1]);
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			if (listener != null) {
				listener.end(result);
			}
		}
		
	}
	
	public void logoutAccount(String tel,String token){
		new AnyTask().execute(tel,token);
	}
}
