package com.zhangwenbin.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.adapter.MyRecordsAdapter;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

public class MyRecords extends Activity {
	ListView listView;
	ArrayList<MyRecordsDemo> data=new ArrayList<MyRecordsDemo>();
	MyRecordsAdapter adapter;
	ImageView intentLoginName;
	RadioButton intentHomePage;
	RadioButton intentClassify;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_records);
		listView = (ListView) findViewById(R.id.my_records_listview);
		getData();
		adapter = new MyRecordsAdapter(data, MyRecords.this);
		listView.setAdapter(adapter);
		
		intentLoginName = (ImageView) findViewById(R.id.myrecords_intent_loginname);
		intentLoginName.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			
			
				
			case R.id.myrecords_intent_loginname:
				finish();
				break;

			default:
				break;
			}
		}

	};

	public void getData() {
		for (int i = 0; i < 3; i++) {
			MyRecordsDemo myRecord = new MyRecordsDemo();
			myRecord.setImage(R.drawable.ic_launcher);
			myRecord.setMy_records_shop_name("欧姆龙专卖店");
			myRecord.setMy_records_list_goodsstates("店家已发货");
			myRecord.setMy_records_content("如果你无法简洁的表达你的想法，那只说明你还不够了解他");
			myRecord.setMy_records_shop_type("TH457A ￥55.00");
			myRecord.setMy_records_shop_number("共一件商品  实付：");
			myRecord.setMy_records_shop_money("￥50.00");
			data.add(myRecord);
		}

	}

}
