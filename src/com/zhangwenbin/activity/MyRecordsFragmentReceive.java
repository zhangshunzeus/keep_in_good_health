package com.zhangwenbin.activity;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zhangshun.adapter.MyRecordsAdapter;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
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
	String address = "";
	String response = HttpUtil.sendHttpRequest(address, new HttpCallBackInterface() {

		public void onFinish(String response) {
			// TODO Auto-generated method stub
			// 在这里根据返回内容执行具体的逻辑，处理响应数据
		}

		public void onError(Exception e) {
			// TODO Auto-generated method stub
			// 在这里对异常情况进行处理
		}
	});

	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listView = (ListView) getView().findViewById(R.id.my_records_listview);
		getData();
		adapter = new MyRecordsAdapter(data, getActivity());
		listView.setAdapter(adapter);
		// getJsonObject(response);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.my_records_receive, container, false);

	}

	public void getData() {
		for (int i = 0; i < 3; i++) {
			//myrecords的listview数据
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

	public void getJsonObject(String jsonData) {
		//解析json数据
		JSONArray jsonArray;
		try {
			jsonArray = new JSONArray(jsonData);
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String id = jsonObject.getString("id");
				String name = jsonObject.getString("name");
				String version = jsonObject.getString("verson");

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
