package com.zhangshun.activity;

import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class HomePageActivity extends Activity {

	RadioButton home_page,classify,circle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);

		home_page = (RadioButton) findViewById (R.id.home_page);
		classify = (RadioButton) findViewById (R.id.classify);
		circle = (RadioButton) findViewById (R.id.circle);
		
		home_page.setOnCheckedChangeListener(listener);
		classify.setOnCheckedChangeListener(listener);
		circle.setOnCheckedChangeListener(listener);
		
	}
	
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
