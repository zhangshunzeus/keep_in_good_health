package com.zhangshun.activity;

import com.jiangkaiquan.activity.Recomend;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import com.zhangwenbin.activity.TodayEat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomePageActivity extends Activity {

	Button my_friend_issue_group_tx, my_friend_car_tx;
	TextView dietary,intent_food;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		my_friend_issue_group_tx = (Button) findViewById(R.id.my_friend_issue_group_tx);
		my_friend_car_tx = (Button) findViewById(R.id.my_friend_car_tx);
		dietary = (TextView) findViewById (R.id.dietary);
		intent_food = (TextView) findViewById (R.id.intent_food);

		my_friend_issue_group_tx.setOnClickListener(listener);
		my_friend_car_tx.setOnClickListener(listener);
		dietary.setOnClickListener(listener);
		intent_food.setOnClickListener(listener);

	}

	OnClickListener listener = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.my_friend_issue_group_tx:
				// Intent intent = new Intent();
				// intent.setClass(HomePageActivity.this,  .class);
				//startActivity(intent);
				break;
			case R.id.my_friend_car_tx:
				Intent intent = new Intent();
				intent.setClass(HomePageActivity.this, PersonalCenterLoginName.class);
				startActivity(intent);
				break;
			case R.id.dietary:
				Intent intetn_dietary = new Intent();
				intetn_dietary.setClass(HomePageActivity.this,Recomend.class);
				startActivity(intetn_dietary);
				break;
			case R.id.intent_food:
				Intent intent_todayEat = new Intent();
				intent_todayEat.setClass(HomePageActivity.this, TodayEat.class);
				startActivity(intent_todayEat);
				break;
			default:
				break;
			}
		}
	};
}
