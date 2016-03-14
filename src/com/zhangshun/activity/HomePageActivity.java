package com.zhangshun.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.zhangshun.keep_in_good_health.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class HomePageActivity extends Activity {

	Button my_friend_issue_group_tx, my_friend_car_tx;
	TextView dietary, intent_food;
	GridView home_page_gridview;
	private SimpleAdapter sim_adapter;
	private List<Map<String, Object>> data_list;
	// 图片封装为一个数组
	private int[] icon = { R.drawable.rub_course_group_category_family, R.drawable.rub_course_group_category_family,
			R.drawable.rub_course_group_category_family, R.drawable.rub_course_group_category_family,
			R.drawable.rub_course_group_category_family, R.drawable.rub_course_group_category_family,
			R.drawable.rub_course_group_category_family, R.drawable.rub_course_group_category_family };
	private String[] iconName = { "煲汤", "煲汤", "煲汤", "煲汤", "煲汤", "煲汤", "煲汤", "煲汤" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		home_page_gridview = (GridView) findViewById(R.id.home_page_gridview);
		data_list = new ArrayList<Map<String, Object>>();
		getData();
		// 新建适配器
		String[] from = { "image", "text" };
		int[] to = { R.id.ItemImage, R.id.ItemText };
		sim_adapter = new SimpleAdapter(this, data_list, R.layout.home_page_gridview, from, to);
		// 配置适配器
		home_page_gridview.setAdapter(sim_adapter);
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
