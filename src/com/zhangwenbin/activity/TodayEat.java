package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ruanjiawei.activity.Food_name_Activity;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;

public class TodayEat extends Activity {
	ImageView imageView;
	LinearLayout linearLayout_breakfast;
	LinearLayout linearLayout_lunch;
	LinearLayout linearLayout_lunch_two;
	LinearLayout linearLayout_dinner;
	RadioButton intent_homepage;
	RadioButton intent_classify;
	RadioButton intent_my;
	RadioGroup radioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.today_eat);
		imageView = (ImageView) findViewById(R.id.today_eat_return);
		imageView.setOnClickListener(onClickListener);
		linearLayout_breakfast = (LinearLayout) findViewById(R.id.intent_breakfast);
		linearLayout_breakfast.setOnClickListener(onClickListener);
		linearLayout_lunch = (LinearLayout) findViewById(R.id.intent_lunch);
		linearLayout_lunch.setOnClickListener(onClickListener);
		linearLayout_lunch_two = (LinearLayout) findViewById(R.id.intent_lunch_two);
		linearLayout_dinner = (LinearLayout) findViewById(R.id.intent_dinner);
		linearLayout_dinner.setOnClickListener(onClickListener);

		intent_homepage = (RadioButton) findViewById(R.id.todayeat_intent_homepage);
		intent_homepage.setOnCheckedChangeListener(listener);
		intent_classify = (RadioButton) findViewById(R.id.todayeat_intent_Classify);
		intent_classify.setOnCheckedChangeListener(listener);
		intent_my = (RadioButton) findViewById(R.id.todayeat_intent_my);
		intent_my.setOnCheckedChangeListener(listener);
	}

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.todayeat_intent_homepage:
				Intent intent_homepage = new Intent();
				intent_homepage.setClass(TodayEat.this, HomePageActivity.class);
				startActivity(intent_homepage);
				break;
			case R.id.todayeat_intent_Classify:
				Intent intent_class = new Intent();
				intent_class.setClass(TodayEat.this,
						CommonDiseasesListForDetailsAcitivty.class);
				startActivity(intent_class);
				break;
			case R.id.todayeat_intent_my:
				Intent intent_my = new Intent();
				intent_my
						.setClass(TodayEat.this, PersonalCenterLoginName.class);
				startActivity(intent_my);
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
			case R.id.today_eat_return:
				Intent intent = new Intent(TodayEat.this,
						HomePageActivity.class);
				startActivity(intent);
				break;
			case R.id.intent_breakfast:
				Intent intent_breakfast = new Intent();
				startActivity(intent_breakfast);
				break;
			case R.id.intent_lunch:
				Intent intent_lunch = new Intent(TodayEat.this,
						Food_name_Activity.class);
				startActivity(intent_lunch);
				break;
			case R.id.intent_lunch_two:
				Intent intent_lunch_two = new Intent();
				startActivity(intent_lunch_two);
				break;
			case R.id.intent_dinner:
				Intent intent_dinner = new Intent();
				startActivity(intent_dinner);
				break;

			default:
				break;
			}
		}

	};

}
