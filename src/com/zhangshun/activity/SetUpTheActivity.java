package com.zhangshun.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class SetUpTheActivity extends Activity {

	ImageView set_up_the_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.set_up_the_activity);
		
		set_up_the_btn = (ImageView) findViewById (R.id.set_up_the_btn);
		set_up_the_btn.setOnClickListener(click);
	
	}
	
	OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.set_up_the_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};
	
}
