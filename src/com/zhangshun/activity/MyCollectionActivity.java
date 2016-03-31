package com.zhangshun.activity;

import java.util.ArrayList;
import com.zhangshun.adapter.MyCollectionAdapter;
import com.zhangshun.demo.MyCollectionDemo;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class MyCollectionActivity extends Activity {
	
	MyCollectionAdapter mAdapter;
	ListView mList;
	ArrayList<MyCollectionDemo> list = new ArrayList<MyCollectionDemo>();
	ImageView return_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_collection_activity);
		mList = (ListView) findViewById (R.id.my_collection_list);
		getData();
		mAdapter = new MyCollectionAdapter(this,list);
		mList.setAdapter(mAdapter);
		return_btn = (ImageView) findViewById (R.id.return_btn);
		return_btn.setOnClickListener(click);
	}
	
	private void getData(){
		
		for(int i = 0; i < 5; i++){
			MyCollectionDemo buy_one = new MyCollectionDemo();
			buy_one.setImg(R.drawable.electric_heating_protect_to_shoulder);
			buy_one.setContent_title("");
			buy_one.setMy_collection_content("");
			list.add(buy_one);
		}
		
	}
	
	OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.return_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};

}
