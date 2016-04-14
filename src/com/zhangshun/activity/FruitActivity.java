package com.zhangshun.activity;

import com.ruanjiawei.activity.Food_name_Activity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class FruitActivity extends Activity {

	ImageView fruit_return_btn;
	RelativeLayout pineapple;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fruit);
		fruit_return_btn = (ImageView) findViewById(R.id.fruit_return_btn);
		fruit_return_btn.setOnClickListener(click);
		
		pineapple=(RelativeLayout) findViewById(R.id.pineapple);
		pineapple.setOnClickListener(click);

	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.fruit_return_btn:
				finish();
				break;
			case R.id.pineapple:
				Intent intent=new Intent(FruitActivity.this,Food_name_Activity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
	};

}

