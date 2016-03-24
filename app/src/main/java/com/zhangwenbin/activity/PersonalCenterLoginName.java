package com.zhangwenbin.activity;

import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class PersonalCenterLoginName extends Activity {
	
	Button my_friend_new_tx,my_friend_issue_group_tx;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_login_name);
		
		my_friend_new_tx = (Button) findViewById(R.id.my_friend_new_tx);
		my_friend_issue_group_tx = (Button) findViewById(R.id.my_friend_issue_group_tx);
		
		my_friend_new_tx.setOnClickListener(listener);
		my_friend_issue_group_tx.setOnClickListener(listener);
		
	}
	
	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.my_friend_new_tx:
				Intent intent = new Intent();
				intent.setClass(PersonalCenterLoginName.this, HomePageActivity.class);
				startActivity(intent);
				break;
			case R.id.my_friend_issue_group_tx:
				break;
			default:
				break;
			}
		}
		
	};

}
