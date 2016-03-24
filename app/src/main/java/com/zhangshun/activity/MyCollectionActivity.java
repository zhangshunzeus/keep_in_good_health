package com.zhangshun.activity;

import java.util.ArrayList;

import com.zhangshun.adapter.MyCollectionAdapter;
import com.zhangshun.demo.MyCollectionDemo;
import com.zhangshun.keep_in_good_health.R;
import com.zhangshun.keep_in_good_health.R.attr;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MyCollectionActivity extends Activity {
	
	MyCollectionAdapter mAdapter;
	ListView mList;
	ArrayList<MyCollectionDemo> list = new ArrayList<MyCollectionDemo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collection_activity);
		mList = (ListView) findViewById (R.id.my_collection_list);
		getData();
		mAdapter = new MyCollectionAdapter(this,list);
		mList.setAdapter(mAdapter);
	}
	
	private void getData(){
		for(int i = 0; i < 10; i++){
			MyCollectionDemo buy = new MyCollectionDemo();
			buy.setImg("");
			buy.setContent_title("标题");
			buy.setMy_collection_content("如果你无法简洁的表达你的想法，那只说明你还不够了解它");
			buy.setContent_list_btn(R.drawable.rub_course_go_to_next_right);
			list.add(buy);
		}
	}

}
