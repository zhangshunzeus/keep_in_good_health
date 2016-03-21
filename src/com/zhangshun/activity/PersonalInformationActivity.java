package com.zhangshun.activity;

import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class PersonalInformationActivity extends Activity {

	ImageView return_btn;
	
	//个人信息页面
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal_information);
		
		return_btn = (ImageView) findViewById (R.id.return_btn);
		return_btn.setOnClickListener(click);
		
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
