package com.zhangshun.activity;

import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;

public class HomePageActivity extends Activity {

	RadioButton home_page,classify,circle;
	ImageView soup,fruit;
	AutoCompleteTextView home_page_search;
	ArrayAdapter<String> arrayAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.home_page);

		home_page = (RadioButton) findViewById (R.id.home_page);
		classify = (RadioButton) findViewById (R.id.classify);
		circle = (RadioButton) findViewById (R.id.circle);
		
		fruit = (ImageView) findViewById (R.id.fruit);
		fruit.setOnClickListener(click);
		
		home_page.setOnCheckedChangeListener(listener);
		classify.setOnCheckedChangeListener(listener);
		circle.setOnCheckedChangeListener(listener);
		
		home_page_search =(AutoCompleteTextView) findViewById(R.id.home_page_search);
        String [] arr={"煲汤","零嘴","甜点","粥类","水果","肉食","素食","饮茶","今日吃什么","营养早餐"};
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        home_page_search.setAdapter(arrayAdapter);
		
	}
	
	OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.fruit:
				Intent intent_fruit = new Intent();
				intent_fruit.setClass(HomePageActivity.this,FruitActivity.class);
				startActivity(intent_fruit);
				break;

			default:
				break;
			}
		}
	};
	
	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.circle:
				Intent intent_circle= new Intent();
				intent_circle.setClass(HomePageActivity.this,
						PersonalCenterLoginName.class);
				startActivity(intent_circle);
				break;

			default:
				break;
			}
		}
		
	};

}
