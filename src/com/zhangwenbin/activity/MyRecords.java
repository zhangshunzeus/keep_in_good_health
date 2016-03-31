package com.zhangwenbin.activity;

import com.zhangrong.activity.MainActivity;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
			/*我的记录页面*/
public class MyRecords extends Activity {

	ImageView intentLoginName;//返回按钮
	RadioButton intentHomePage;//首页按钮
	RadioButton intentClassify;//分类按钮
	RadioGroup return_home;//group名

	Fragment[] myfragment;
	FragmentTransaction transaction;
	FragmentManager manager;
	RadioGroup radioGroup;
	RadioButton btnAll, btnPayMoney, btnSend, btnReceive, btnComment;//5个链接fragment按钮
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.my_records);
		/*用于跳转监听*/
		return_home = (RadioGroup) findViewById(R.id.my_records_return_home);
		//return_home.setOnClickListener(listener);
		intentClassify = (RadioButton) findViewById(R.id.myrecords_intent_classify);
		//intentClassify.setOnClickListener(listener);
		intentHomePage = (RadioButton) findViewById(R.id.myrecords_intent_homepage);
		//intentHomePage.setOnClickListener(listener);
		/*返回监听*/
		intentLoginName = (ImageView) findViewById(R.id.myrecords_intent_loginname);
		intentLoginName.setOnClickListener(onClickListener);
		//设置需要切换的相对应fragment页面
		myfragment = new Fragment[5];
		manager = getFragmentManager();
		myfragment[0] = manager.findFragmentById(R.id.my_records_all);
		myfragment[1] = manager.findFragmentById(R.id.my_records_pay_money);
		myfragment[2] = manager.findFragmentById(R.id.my_records_send);
		myfragment[3] = manager.findFragmentById(R.id.my_records_receive);
		myfragment[4] = manager.findFragmentById(R.id.my_records_comment);
		
		transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2])
				.hide(myfragment[3]).hide(myfragment[4]);
		transaction.show(myfragment[0]).commit();
		setFragmentIndicator();
	}

	public void setFragmentIndicator() {
		//设置切换按钮的监听，对应相对的页面
		radioGroup = (RadioGroup) findViewById(R.id.rb_group);
		btnAll = (RadioButton) findViewById(R.id.rb_all);
		btnPayMoney = (RadioButton) findViewById(R.id.rb_paymoney);
		btnSend = (RadioButton) findViewById(R.id.rb_send);
		btnReceive = (RadioButton) findViewById(R.id.rb_receive);
		btnComment = (RadioButton) findViewById(R.id.rb_comment);
		radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

	}

	OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
		//监听fragment页面转换
		@SuppressLint("NewApi")
		@Override
		public void onCheckedChanged(RadioGroup arg0, int arg1) {
			// TODO Auto-generated method stub
			transaction = manager.beginTransaction().hide(myfragment[0]).hide(myfragment[1]).hide(myfragment[2])
					.hide(myfragment[3]).hide(myfragment[4]);
			switch (arg1) {
			case R.id.rb_all:
				transaction.show(myfragment[0]).commit();
				break;
			case R.id.rb_paymoney:
				transaction.show(myfragment[1]).commit();
				break;
			case R.id.rb_send:
				transaction.show(myfragment[2]).commit();
				break;
			case R.id.rb_receive:
				transaction.show(myfragment[3]).commit();
				break;
			case R.id.rb_comment:
				transaction.show(myfragment[4]).commit();
				break;
			case R.id.myrecords_intent_classify:
				Intent intent_classify = new Intent(MyRecords.this, MainActivity.class);
				startActivity(intent_classify);
				break;
			case R.id.myrecords_intent_homepage:
				Intent intent_homepage = new Intent(MyRecords.this, HomePageActivity.class);
				startActivity(intent_homepage);
				break;

			default:
				break;
			}
		}

	};
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

}

