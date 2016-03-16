package com.ruanjiawei.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Food_name_Activity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_name);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}
}
