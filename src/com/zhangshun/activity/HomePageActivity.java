package com.zhangshun.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class HomePageActivity extends Activity {

	Button my_friend_issue_group_tx, my_friend_car_tx;
	TextView dietary, intent_food;
	GridView home_page_gridview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		home_page_gridview = (GridView) findViewById(R.id.home_page_gridview);

		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemImage", R.drawable.rub_course_group_category_family);// 添加图像资源的ID
			map.put("ItemText", "NO." + String.valueOf(i));// 按序号做ItemText
			lstImageItem.add(map);
		}
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter saImageItems = new SimpleAdapter(this, // 没什么解释
				lstImageItem, // 数据来源
				R.layout.home_page_gridview, // night_item的XML实现

		// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage", "ItemText"},

		// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ItemImage, R.id.ItemText});
		// 添加并且显示
		home_page_gridview.setAdapter(saImageItems);
		// 添加消息处理
		home_page_gridview.setOnItemClickListener(new ItemClickListener());

		/*
		 * my_friend_issue_group_tx = (Button)
		 * findViewById(R.id.my_friend_issue_group_tx); my_friend_car_tx =
		 * (Button) findViewById(R.id.my_friend_car_tx); dietary = (TextView)
		 * findViewById (R.id.dietary); intent_food = (TextView) findViewById
		 * (R.id.intent_food);
		 * 
		 * my_friend_issue_group_tx.setOnClickListener(listener);
		 * my_friend_car_tx.setOnClickListener(listener);
		 * dietary.setOnClickListener(listener);
		 * intent_food.setOnClickListener(listener);
		 */

	}

	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	class  ItemClickListener implements OnItemClickListener  
	  {  
	public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened   
	                                  View arg1,//The view within the AdapterView that was clicked  
	                                  int arg2,//The position of the view in the adapter  
	                                  long arg3//The row id of the item that was clicked  
	                                  ) {  
	    //在本例中arg2=arg3  
	    HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);  
	    //显示所选Item的ItemText  
	    setTitle((String)item.get("ItemText"));  
	}  

	/*OnClickListener listener = new OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.my_friend_issue_group_tx:
				// Intent intent = new Intent();
				// intent.setClass(HomePageActivity.this,  .class);
				//startActivity(intent);
				break;
			case R.id.my_friend_car_tx:
				Intent intent = new Intent();
				intent.setClass(HomePageActivity.this, PersonalCenterLoginName.class);
				startActivity(intent);
				break;
			case R.id.dietary:
				Intent intetn_dietary = new Intent();
				intetn_dietary.setClass(HomePageActivity.this,Recomend.class);
				startActivity(intetn_dietary);
				break;
			case R.id.intent_food:
				Intent intent_todayEat = new Intent();
				intent_todayEat.setClass(HomePageActivity.this, TodayEat.class);
				startActivity(intent_todayEat);
				break;
			default:
				break;
			}
		}
	};*/
}
}
