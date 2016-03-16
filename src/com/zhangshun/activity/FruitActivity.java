package com.zhangshun.activity;

import com.zhangshun.keep_in_good_health.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class FruitActivity extends Activity {

	ImageView fruit_return_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fruit);
		fruit_return_btn = (ImageView) findViewById(R.id.fruit_return_btn);
		fruit_return_btn.setOnClickListener(click);

	}


	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.fruit_return_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};

}
