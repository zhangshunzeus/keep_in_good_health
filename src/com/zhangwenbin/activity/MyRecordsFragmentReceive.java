package com.zhangwenbin.activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zhangshun.adapter.MyRecordsAdapter;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/*我的記錄中的fragment相對的待收貨頁面*/
@SuppressLint("NewApi")
public class MyRecordsFragmentReceive extends Fragment {
	ListView listView;
	ArrayList<MyRecordsDemo> data = new ArrayList<MyRecordsDemo>();
	MyRecordsAdapter adapter;
	String url="http://192.168.11.247/index.php/home/api/changeser";
	

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listView = (ListView) getView().findViewById(R.id.my_records_listview);
		// getData();
		
		mTask.execute("fdsa");

	}

	AsyncTask<String, String, Context> mTask = new AsyncTask<String, String, Context>() {

		@Override
		protected Context doInBackground(String... arg0) {
			// TODO Auto-generated method stub
			Log.i("onActivity", "=========");
			sendResultRecponse(url);
			return getActivity();
		}

		protected void onPostExecute(Context result) {

		};

	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.my_records_receive, container, false);

	}
	
	public void getData() {
		for (int i = 0; i < 3; i++) {
			// myrecords的listview数据
			MyRecordsDemo myRecord = new MyRecordsDemo();
			//myRecord.setImage(R.drawable.myrecords_picture_one);
			myRecord.setMy_records_shop_name("欧姆龙专卖店");
			myRecord.setMy_records_list_goodsstates("店家已发货");
			myRecord.setMy_records_content("OMRON欧姆龙红外耳饰体温计");
			myRecord.setMy_records_shop_type("TH457A ￥55.00");
			myRecord.setMy_records_shop_number("共一件商品  实付：");
			myRecord.setMy_records_shop_money("￥50.00");
			// myRecord.setMy_records_change_receiving(R.drawable.selector_change_receive);
			data.add(myRecord);
			/*
			 * MyRecordsDemo myRecord_one = new MyRecordsDemo();
			 * myRecord_one.setImage(R.drawable.myrecords_picture_two);
			 * myRecord_one.setMy_records_shop_name("鼎力托玛琳自然热四季款护腰带");
			 * myRecord_one.setMy_records_list_goodsstates("店家已发货");
			 * myRecord_one.setMy_records_content("鼎力托玛琳自然热四季款护腰带");
			 * myRecord_one.setMy_records_shop_type("领款中号 ￥184.00");
			 * myRecord_one.setMy_records_shop_number("共一件商品  实付：");
			 * myRecord_one.setMy_records_shop_money("￥180.00");
			 * //myRecord_one.setMy_records_change_receiving(R.drawable.
			 * no_check_change_receive); data.add(myRecord_one);
			 */
		}
	}

	public void sendResultRecponse(String url) {

		// 使用HTTPclient请求数据响应，并调用getjsonobject（）方法经行数据解析

		// TODO Auto-generated method stub
		BasicHttpParams basicHttpParams = new BasicHttpParams();
		HttpConnectionParams.setConnectionTimeout(basicHttpParams, 8000);
		HttpConnectionParams.setSoTimeout(basicHttpParams, 8000);

		try {
			HttpClient httpClient = new DefaultHttpClient(basicHttpParams);
			HttpGet httpGet = new HttpGet(url);
			httpClient.execute(httpGet);
			HttpResponse httpResponse = httpClient.execute(httpGet);
			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = httpResponse.getEntity();
				String response = EntityUtils.toString(entity, "utf-8");
				JSONArray jsonArray = new JSONArray(response);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject jsonObject = jsonArray.getJSONObject(i);
					MyRecordsDemo demo = new MyRecordsDemo();
					String name = jsonObject.getString("name");
					String sendstates = jsonObject.getString("sendstates");
					String content = jsonObject.getString("content");
					String money = jsonObject.getString("money");
					String number = jsonObject.getString("number");
					String type = jsonObject.getString("type");
					String image=jsonObject.getString("image");
					demo.setMy_records_shop_name(name);
					demo.setMy_records_list_goodsstates(sendstates);
					demo.setMy_records_content(content);
					demo.setMy_records_shop_money(money);
					demo.setMy_records_shop_number(number);
					demo.setMy_records_shop_type(type);
					demo.setImage(getPic(image));
					data.add(demo);
					Log.i("name", name + "");
					Log.i("sendstates", sendstates + "");
					Log.i("content", content + "");
					Log.i("money", money + "");
					Log.i("number", number + "");
					Log.i("type", type + "");
				}
				adapter = new MyRecordsAdapter(data, getActivity());
				listView.setAdapter(adapter);

			}
			Log.i("my", httpResponse + "");
		} catch (ClientProtocolException e) {
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
	
	// 传输网络图片
	public Bitmap getPic(String urlImage) {
	    URL imageUrl = null;
	    Bitmap bitmap = null;
	    try {
	        imageUrl = new URL(urlImage);
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	    try {
	        HttpURLConnection conn = (HttpURLConnection) imageUrl
	                .openConnection();
	        conn.connect();
	        InputStream is = conn.getInputStream();
	        bitmap = BitmapFactory.decodeStream(is);
	 
	        is.close();
	 
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return bitmap;
	}


	public void sendResultPost() {
		new Thread(new Runnable() {
			// 使用post向服务器传递数据，发送请求信息
			@Override
			public void run() {
				// TODO Auto-generated method stub
				BasicHttpParams basicHttpParams = new BasicHttpParams();
				HttpConnectionParams.setConnectionTimeout(basicHttpParams, 8000);
				HttpConnectionParams.setSoTimeout(basicHttpParams, 8000);

				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost();
				List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
				valuePairs.add(new BasicNameValuePair("id", "1"));
				// valuePairs.add(new BasicNameValuePair("password", "123456"));
				UrlEncodedFormEntity entity;
				try {
					entity = new UrlEncodedFormEntity(valuePairs, "utf-8");
					httpPost.setEntity(entity);
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					httpClient.execute(httpPost);
					HttpResponse httpResponse = httpClient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity httpEntity = httpResponse.getEntity();
						String response = EntityUtils.toString(httpEntity);
						Log.i("my_ok", response);
					}
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

}
