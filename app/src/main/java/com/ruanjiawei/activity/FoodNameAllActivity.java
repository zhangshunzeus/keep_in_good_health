package com.ruanjiawei.activity;

import java.util.ArrayList;

import com.ruajiawei.baseadapter.FoodNameAllBaseAdapter;
import com.ruanjiawei.demo.FoodNameAllInfo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class FoodNameAllActivity extends Activity {
	ArrayList<FoodNameAllInfo> list = new ArrayList<FoodNameAllInfo>();
	ListView listview;
	FoodNameAllBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food_name_all);
		listview = (ListView) findViewById(R.id.food_name_all_listview);
		getData();
		adapter = new FoodNameAllBaseAdapter(list, this);
		listview.setAdapter(adapter);
	}

	private void getData() {
		// TODO Auto-generated method stub
		FoodNameAllInfo all=new FoodNameAllInfo();
		all.setFood_name_all_listview_image(R.drawable.ic_launcher);
		all.setFood_name_all_listview_text("如果你无法简洁的表达你的想法，那只说明你还不够了解它。 \n -- 阿尔伯特·爱因斯坦");
		list.add(all);
		list.add(all);
		list.add(all);
		list.add(all);
	}

}
