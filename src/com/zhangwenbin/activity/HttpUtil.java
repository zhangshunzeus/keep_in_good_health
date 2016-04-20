package com.zhangwenbin.activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtil {
	//公共的类，用于HTTP请求，获得响应response数据
	public static String sendHttpRequest(final String address,final HttpCallBackInterface interfaceHttp){
		
		new Thread(new Runnable() {
		
			@Override 
			public void run() {
				// TODO Auto-generated method stub
				HttpURLConnection connection=null;
				
				try {
					URL url=new URL(address);
					connection=(HttpURLConnection)url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					connection.setDoInput(true);
					connection.setDoOutput(true);
					InputStream inputStream=connection.getInputStream();
					BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
					StringBuilder response=new StringBuilder();
					String line;
					while ((line=reader.readLine())!=null) {
						response.append(line);
					}
					if (interfaceHttp!=null) {
						//回调onFinish（）方法
						interfaceHttp.onFinish(response.toString());
					}
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					if (interfaceHttp!=null) {
						//回调onError()方法
						interfaceHttp.onError(e);
					}
				}finally {
					if (connection!=null) {
						connection.disconnect();
					}
				}			
			}
		}).start();
		return address;
	}

}
