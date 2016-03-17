package com.ruanjiawei.activity;

import java.util.ArrayList;

import com.ruajiawei.baseadapter.FoodNameAllBaseAdapter;
import com.ruanjiawei.demo.FoodNameAllInfo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class MoreActivity extends Activity {
	ArrayList<FoodNameAllInfo> list = new ArrayList<FoodNameAllInfo>();
	ListView listview;
	FoodNameAllBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.more);

		listview = (ListView) findViewById(R.id.more_listview);
		getData();
		adapter = new FoodNameAllBaseAdapter(list, this);
		listview.setAdapter(adapter);
	}

	private void getData() {
		// TODO Auto-generated method stub
		FoodNameAllInfo all = new FoodNameAllInfo();
		all.setMore_listview_image(R.drawable.more_one);
		all.setMore_name_all_listview_title("汤臣倍健R蛋白粉");
		all.setMore_name_all_listview_weight("450g/罐（附量具）");
		all.setMore_name_all_listview_giving("增强免疫力 送小蛋粉 150g");
		all.setMore_name_all_listview_price("26.00");
		all.setMore_name_all_listview_nice("89%");
		list.add(all);
		FoodNameAllInfo food = new FoodNameAllInfo();
		food.setMore_listview_image(R.drawable.more_three);
		food.setMore_name_all_listview_title("善存R佳维片");
		food.setMore_name_all_listview_giving("1.33g/片*150片");
		food.setMore_name_all_listview_price("15.00");
		food.setMore_name_all_listview_nice("95%");
		list.add(food);
		FoodNameAllInfo foodname = new FoodNameAllInfo();
		foodname.setMore_listview_image(R.drawable.more_four);
		foodname.setMore_name_all_listview_title("钙尔奇牌添佳片");
		foodname.setMore_name_all_listview_giving("1.04g/片*3瓶套餐");
		foodname.setMore_name_all_listview_price("15.00");
		foodname.setMore_name_all_listview_nice("95%");
		list.add(foodname);
		FoodNameAllInfo all3 = new FoodNameAllInfo();
		all3.setMore_listview_image(R.drawable.more_two);
		all3.setMore_name_all_listview_title("碧生源牌减肥茶");
		all3.setMore_name_all_listview_giving("2.5g/袋*15袋/盒*4盒");
		all3.setMore_name_all_listview_price("31.00");
		food.setMore_name_all_listview_nice("95%");
		list.add(all3);
		
	}

}
