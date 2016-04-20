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

public class ForgetPasswordTools {
	String message;
	public int status=0;
	
	
	public void forgerpasswordAccount(String tel, String verify, String password,
			String repassword){
		new AnyTask().execute(tel, verify, password, repassword);
	}

	//更改密码地址
	
	private String forgerpassword(String tel, String verify, String password,
			String repassword) {
		StringBuilder builder = new StringBuilder();
		String httpHost = "http://211.149.198.8:9803/index.php/home/api/forgetpassword";
		String urltel = "tel=";
		String verifykey = "verify=";
		String passwordkey = "password=";
		String repasswordkey = "repassword=";

		URL url;

		try {

			String urlforget = httpHost + "?" + verifykey + verify + "&"
					+ urltel + tel + "&" + passwordkey + password + "&"
					+ repasswordkey + repassword;
			url = new URL(urlforget);

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "error";

	}

	OnForgetPasswordListener lisener;
	
	public void setOnForgetPasswordListener(OnForgetPasswordListener lisener){
		this.lisener=lisener;
	}
	
	@SuppressLint("NewApi")
	class AnyTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			return forgerpassword(arg0[0],arg0[1], arg0[2], arg0[3]);
			
		}
		
		protected void onPostExecute(String result) {
			if(lisener !=null){
				lisener.end(result);
			}
		}
		
		
	}

	public interface OnForgetPasswordListener {
		void start();

		void end(String result);
	}

	public String getMessage() {
		return message;
	}

}
