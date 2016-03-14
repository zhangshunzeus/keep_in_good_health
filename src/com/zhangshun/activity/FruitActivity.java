package com.zhangshun.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class FruitActivity extends Activity {

	GridView fruit_gridview;
	SimpleAdapter sim_adapter;
	List<Map<String, Object>> data_list;
	// 图片封装为一个数组
		private int[] icon = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		private String[] iconName = { "水果","水果","水果","水果","水果","水果"  };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fruit);
		fruit_gridview = (GridView) findViewById(R.id.fruit_gridview);
		data_list = new ArrayList<Map<String, Object>>();
		getData();
		// 新建适配器
		String[] from = { "image", "text" };
		int[] to = {R.id.gridview_img,R.id.describe};
		sim_adapter = new SimpleAdapter(this, data_list, R.layout.fruit_gridview, from, to);
		// 配置适配器
		fruit_gridview.setAdapter(sim_adapter);
	}
	
	public List<Map<String, Object>> getData() {
		// cion和iconName的长度是相同的，这里任选其一都可以
		for (int i = 0; i < icon.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("image", icon[i]);
			map.put("text", iconName[i]);
			data_list.add(map);
		}

		return data_list;
	}
	
}
