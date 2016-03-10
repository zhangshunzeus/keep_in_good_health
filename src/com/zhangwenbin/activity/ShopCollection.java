package com.zhangwenbin.activity;

import java.util.ArrayList;

import com.zhangshun.adapter.ShopCollectionAdapter;
import com.zhangshun.demo.ShopCollectionDemo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class ShopCollection extends Activity {
	ListView listView;
	ArrayList<ShopCollectionDemo> data;
	ShopCollectionAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.shop_collection);
		listView=(ListView)findViewById(R.id.shop_collection_listview);
		getData();
		adapter=new ShopCollectionAdapter(data,ShopCollection.this);
		
	}
	
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
