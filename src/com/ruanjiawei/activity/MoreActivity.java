package com.ruanjiawei.activity;

import java.util.ArrayList;

import com.ruajiawei.baseadapter.FoodNameAllBaseAdapter;
import com.ruanjiawei.demo.FoodNameAllInfo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class MoreActivity extends Activity {
	ArrayList<FoodNameAllInfo> list = new ArrayList<FoodNameAllInfo>();
	ListView listview;
	FoodNameAllBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more);
		listview = (ListView) findViewById(R.id.more_listview);
		getData();
		adapter = new FoodNameAllBaseAdapter(list, this);
		listview.setAdapter(adapter);
	}

	private void getData() {
		// TODO Auto-generated method stub
		FoodNameAllInfo all = new FoodNameAllInfo();
		all.setMore_listview_image(R.drawable.ic_launcher);
		all.setMore_name_all_listview_title("汤臣倍建R蛋白粉");
		all.setMore_name_all_listview_weight("450g/罐（附量具）");
		all.setMore_name_all_listview_giving("增强免疫力 送小蛋粉 150g");
		all.setMore_name_all_listview_price("26.00");
		all.setMore_name_all_listview_nice("89%");
		FoodNameAllInfo all1 = new FoodNameAllInfo();
		all1.setMore_listview_image(R.drawable.ic_launcher);
		all1.setMore_name_all_listview_title("善存R佳维片");
		all1.setMore_name_all_listview_giving("1.33g/片*150片");
		all1.setMore_name_all_listview_price("15.00");
		all1.setMore_name_all_listview_nice("95%");
		list.add(all);
		list.add(all1);
		list.add(all1);
		list.add(all1);
		list.add(all1);
		list.add(all1);
		list.add(all1);
		list.add(all1);
	}

}
