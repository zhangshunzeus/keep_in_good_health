package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class Food_name_Activity extends Activity {
	ImageView black;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.food_name);

		black = (ImageView) findViewById(R.id.black);
		black.setOnClickListener(l);
	}
 
	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.black:
				finish();
				break;

			default:
				break;
			}
		}
	};
}

