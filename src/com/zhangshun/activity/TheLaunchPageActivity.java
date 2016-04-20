package com.zhangshun.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.zhangrong.activity.MainActivity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TheLaunchPageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.the_launch_page_activity);

		
		final Intent localIntent = new Intent(this, MainActivity.class);
		
		Timer timer = new Timer();
		TimerTask tast = new TimerTask() {
			@Override
			public void run() {
				startActivity(localIntent);
			}
		};
		timer.schedule(tast, 5000);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
	}
	
}
