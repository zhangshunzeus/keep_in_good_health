package com.zhangwenbin.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

public class Inquiry_doctor extends Activity {
	ImageView imageViewReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.inquiry_doctor);
		imageViewReturn=(ImageView)findViewById(R.id.doctor_return);
		imageViewReturn.setOnClickListener(onClickListener);
		
	}
	
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.doctor_return:
				Intent intent=new Intent();
				startActivity(intent);
				break;

			default:
				break;
			}
		}
		
		
	};

}
