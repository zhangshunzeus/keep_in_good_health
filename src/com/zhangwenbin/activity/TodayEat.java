package com.zhangwenbin.activity;

import com.ruanjiawei.activity.Food_name_Activity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TodayEat extends Activity {
	ImageView imageView;
	LinearLayout linearLayout_breakfast;
	LinearLayout linearLayout_lunch;
	LinearLayout linearLayout_lunch_two;
	LinearLayout linearLayout_dinner;

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

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			/*跳转到返回页*/
			case R.id.today_eat_return:
				finish();
				break;
				
			case R.id.intent_breakfast:
				Intent intent_breakfast = new Intent();
				startActivity(intent_breakfast);
				break;
			case R.id.intent_lunch:
				/*跳转到午餐*/
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
