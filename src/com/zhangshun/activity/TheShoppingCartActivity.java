package com.zhangshun.activity;

import java.util.ArrayList;
import com.zhangshun.adapter.TheShoppingCartAdapter;
import com.zhangshun.demo.TheShoppingCartDemo;
import com.zhangshun.keep_in_good_health.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

public class TheShoppingCartActivity extends Activity {

	TheShoppingCartAdapter mAdapter;
	ListView mList;
	ArrayList<TheShoppingCartDemo> list = new ArrayList<TheShoppingCartDemo>();
	ImageView the_shopping_cart_return_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.the_shopping_cart_activity);
		mList = (ListView) findViewById(R.id.the_shopping_cart_list);
		// 为Adapter准备数据
		getData();
		// 实例化自定义的Adapter
		mAdapter = new TheShoppingCartAdapter(this, list);
		// 绑定Adapter
		mList.setAdapter(mAdapter);
		the_shopping_cart_return_btn = (ImageView) findViewById(R.id.the_shopping_cart_return_btn);
		the_shopping_cart_return_btn.setOnClickListener(click);

	}
	private void getData() {

		for (int i = 0; i < 3; i++) {
			TheShoppingCartDemo buy = new TheShoppingCartDemo();
			buy.setImg(R.drawable.pu_er_tea);
			buy.setThe_shopping_title("");
			buy.setThe_shopping_content("");
			buy.setThe_shopping_number("");
			buy.setThe_price("");
			list.add(buy);
		}

	}

	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.the_shopping_cart_return_btn:
				finish();
				break;
			case R.id.Future_generations_all:

				break;
			default:
				break;
			}
		}
	};

}
