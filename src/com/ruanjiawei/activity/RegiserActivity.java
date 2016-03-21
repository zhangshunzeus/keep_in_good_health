package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class RegiserActivity extends Activity {

	ImageView myrecords_return_btn;
	Button register_ok_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.register);
		
		myrecords_return_btn = (ImageView) findViewById(R.id.myrecords_return_btn);
		myrecords_return_btn.setOnClickListener(l);
		register_ok_btn = (Button) findViewById(R.id.register_ok_btn);
		register_ok_btn.setOnClickListener(l);

	}
	
	OnClickListener l = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.myrecords_return_btn:
				finish();
				break;
			case R.id.register_ok_btn:
				finish();
				break;
			default:
				break;
			}
		}
	};
	
}
