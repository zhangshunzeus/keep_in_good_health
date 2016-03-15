package com.zhangshun.activity;

import java.util.ArrayList;
import com.zhangshun.adapter.TheShoppingCartAdapter;
import com.zhangshun.demo.TheShoppingCartDemo;
import com.zhangshun.keep_in_good_health.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class TheShoppingCartActivity extends Activity {

	TheShoppingCartAdapter mAdapter;
	ListView mList;
	ArrayList<TheShoppingCartDemo> list = new ArrayList<TheShoppingCartDemo>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.the_shopping_cart_activity);
		mList = (ListView) findViewById (R.id.the_shopping_cart_list);
		getData();
		mAdapter = new TheShoppingCartAdapter(this,list);
		mList.setAdapter(mAdapter);
	}
	
	private void getData() {
		
		for(int i = 0; i < 3; i++){
			TheShoppingCartDemo buy = new TheShoppingCartDemo();
			buy.setImg(R.drawable.pu_er_tea);
			buy.setThe_shopping_title("");
			buy.setThe_shopping_content("");
			buy.setThe_shopping_number("");
			buy.setThe_price("");
			list.add(buy);
		}
		
	}
	
}
