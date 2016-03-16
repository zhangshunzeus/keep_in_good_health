package com.zhangwenbin.activity;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ListView;
import android.widget.RadioButton;

import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.adapter.ShopCollectionAdapter;
import com.zhangshun.demo.ShopCollectionDemo;
import com.zhangshun.keep_in_good_health.R;

public class ShopCollection extends Activity {
	ListView listView;
	ArrayList<ShopCollectionDemo> data;
	ShopCollectionAdapter adapter;
	RadioButton shopCollectIntentHomePage;
	RadioButton shopCollectIntentClassify;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shop_collection);
		listView=(ListView)findViewById(R.id.shop_collection_listview);
		getData();
		adapter=new ShopCollectionAdapter(data,ShopCollection.this);
		
		shopCollectIntentHomePage=(RadioButton)findViewById(R.id.shopcollect_intent_homepage);
		shopCollectIntentHomePage.setOnClickListener(onClickListener);
		shopCollectIntentClassify=(RadioButton)findViewById(R.id.shopcollect_intent_classify);
		shopCollectIntentClassify.setOnClickListener(onClickListener);
		
	}
	
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			/*跳转到分类*/
			case R.id.shopcollect_intent_classify:
				Intent intent_classify=new Intent();
				startActivity(intent_classify);
				break;
				/*跳转到首页*/
			case R.id.shopcollect_intent_homepage:
				Intent intent_homepage=new Intent(ShopCollection.this,HomePageActivity.class);
				startActivity(intent_homepage);
				break;

			default:
				break;
			}
		}
		
		
	};
	
	public void getData(){
		for (int i = 0; i < 3; i++) {
			ShopCollectionDemo demo=new ShopCollectionDemo();
			demo.setShopCollectionImage(R.drawable.ic_launcher);
			demo.setShopCollectionShopName("产品名");
			demo.setShopCollectionMoneyImage(R.drawable.ic_launcher);
			demo.setShopCollectionMoney("35");
			demo.setShopCollectionIntent(R.drawable.ic_launcher);
			data.add(demo);
			
		}
		
	}
}
