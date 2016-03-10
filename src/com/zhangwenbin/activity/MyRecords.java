package com.zhangwenbin.activity;

import java.util.ArrayList;

import com.zhangshun.adapter.MyRecordsAdapter;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class MyRecords extends Activity{
	ListView listView;
	ArrayList<MyRecordsDemo> data;
	MyRecordsAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_records);
		listView=(ListView)findViewById(R.id.my_records_listview);
		getData();
		adapter=new MyRecordsAdapter(data,MyRecords.this);
		listView.setAdapter(adapter);
	}
	
	public void getData(){
		for (int i = 0; i < 3; i++) {
			MyRecordsDemo myRecord=new MyRecordsDemo();
			myRecord.setImage(R.drawable.ic_launcher);
			myRecord.setMy_records_title("标题");
			myRecord.setMy_records_content("如果你无法简洁的表达你的想法，那只说明你还不够了解他");
			myRecord.setMy_records_intent(R.drawable.ic_launcher);
			data.add(myRecord);
		}
		
	}

}
