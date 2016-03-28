package com.zhangwenbin.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import android.os.Bundle;
import android.util.Log;
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

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listView = (ListView) getView().findViewById(R.id.my_records_listview);
		getData();
		//sendResultRecponse();
		adapter = new MyRecordsAdapter(data, getActivity());
		listView.setAdapter(adapter);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.my_records_receive, container, false);

	}

	public void getData() {
		for (int i = 0; i < 3; i++) {
			// myrecords的listview数据
			MyRecordsDemo myRecord = new MyRecordsDemo();
			myRecord.setImage(R.drawable.myrecords_picture_one);
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

	public void sendResultRecponse() {
		new Thread(new Runnable() {
			// 使用HTTPclient请求数据响应，并调用getjsonobject（）方法经行数据解析
			@Override
			public void run() {
				// TODO Auto-generated method stub
				BasicHttpParams basicHttpParams = new BasicHttpParams();
				HttpConnectionParams.setConnectionTimeout(basicHttpParams, 8000);
				HttpConnectionParams.setSoTimeout(basicHttpParams, 8000);

				try {
					HttpClient httpClient = new DefaultHttpClient(basicHttpParams);
					HttpGet httpGet = new HttpGet("http://127.0.0.1/index.php/home/api/changeser");
					httpClient.execute(httpGet);
					HttpResponse httpResponse = httpClient.execute(httpGet);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity = httpResponse.getEntity();
						String response = EntityUtils.toString(entity, "utf-8");
						JSONArray jsonArray=new JSONArray(response);
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject jsonObject =jsonArray.getJSONObject(i);
							MyRecordsDemo demo = new MyRecordsDemo();
							demo.setMy_records_shop_name(jsonObject.getString("name"));
							demo.setMy_records_list_goodsstates(jsonObject.getString("sendstates"));
							demo.setMy_records_content(jsonObject.getString("content"));
							demo.setMy_records_shop_money(jsonObject.getString("money"));
							demo.setMy_records_shop_number(jsonObject.getString("number"));
							demo.setMy_records_shop_type(jsonObject.getString("type"));
							data.add(demo);
							Log.i("my_", demo + "");
						}
				
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
		});
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

	public void getJsonObject(String jsonData) {
		// 解析json数据
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(jsonData);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String id = jsonObject.getString("id");
				String name = jsonObject.getString("name");
				String money = jsonObject.getString("money");
				Log.i("my_id", id);
				Log.i("my_name", name);
				Log.i("my_money", money);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
