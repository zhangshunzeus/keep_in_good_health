package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

public class DetailsBigActivity extends Activity {
	@SuppressLint("WrongViewCast")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		ImageButton details_finish;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shop_details_big);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		details_finish = (ImageButton) findViewById(R.id.details_finish);
		details_finish.setOnClickListener(l);

	}

	OnClickListener l = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.details_finish:
				finish();
				break;

			default:
				break;
			}
		}
	};
}
