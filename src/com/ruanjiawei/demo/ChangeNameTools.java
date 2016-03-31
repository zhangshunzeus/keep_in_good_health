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

public class ChangeNameTools {
	String message;
	public int status = 0;

	public void changenameAccount(String tel, String token, String username) {
		new AnyTask().execute(tel, token, username);
	}

	private String changename(String tel, String token, String username) {

		StringBuilder builder = new StringBuilder();
		String httpHost = "http://192.168.11.241/index.php/home/api/changename";
		String urltel = "tel=";
		String urltoken = "token=";
		String urlname = "username=";

		URL url;
		String urlchangename = httpHost + "?" + urltel + tel + "&" + urltoken
				+ token + "&" + urlname + username;
		try {
			url = new URL(urlchangename);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
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

	OnHttpChangename listener;

	public void setOnHttpChangename(OnHttpChangename listener) {
		this.listener = listener;
	}

	public interface OnHttpChangename {
		void start();

		void end(String result);
	}

	@SuppressLint("NewApi")
	class AnyTask extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return changename(arg0[0], arg0[1], arg0[2]);
		}

		protected void onPostExecute(String result) {
			if (listener != null) {
				listener.end(result);
			}
		}

	}

	public String getMessage() {
		return message;
	}

}
