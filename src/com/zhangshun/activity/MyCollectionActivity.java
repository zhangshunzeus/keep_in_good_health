package com.zhangshun.activity;

import java.util.ArrayList;
import com.zhangshun.adapter.MyCollectionAdapter;
import com.zhangshun.demo.MyCollectionDemo;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class MyCollectionActivity extends Activity {
	
	MyCollectionAdapter mAdapter;
	ListView mList;
	ArrayList<MyCollectionDemo> list = new ArrayList<MyCollectionDemo>();
	ImageView return_btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_collection_activity);
		mList = (ListView) findViewById (R.id.my_collection_list);
		getData();
		mAdapter = new MyCollectionAdapter(this,list);
		mList.setAdapter(mAdapter);
		return_btn = (ImageView) findViewById (R.id.return_btn);
		return_btn.setOnClickListener(click);
	}
	
	private void getData(){
		
		for(int i = 0; i < 5; i++){
			MyCollectionDemo buy_one = new MyCollectionDemo();
			buy_one.setImg(R.drawable.electric_heating_protect_to_shoulder);
			buy_one.setContent_title("电热护肩背");
			buy_one.setMy_collection_content("电热护肩背冬季保暖中老年男女护肩颈部热敷\n理疗信乐边纶布蓝+艾灸包");
			list.add(buy_one);
		}
			
			/*MyCollectionDemo buy_two = new MyCollectionDemo();
			buy_two.setImg(R.drawable.zero_to_round_eye);
			buy_two.setContent_title("零听圆目");
			buy_two.setMy_collection_content("3D立体慢回弹遮光眠眼罩黑色+零听抗噪卫\n士防噪音睡眠耳塞 组合装");
			list.add(buy_two);
			
			MyCollectionDemo buy_three = new MyCollectionDemo();
			buy_three.setImg(R.drawable.electric_heating_belt);
			buy_three.setContent_title("电热护腰带");
			buy_three.setMy_collection_content("轻松艾盐电热护腰带组合装男女士冬季远红外\n热敷腰部保暖尊贵蓝信乐");
			list.add(buy_three);
			
			MyCollectionDemo buy_four = new MyCollectionDemo();
			buy_four.setImg(R.drawable.belt);
			buy_four.setContent_title("护腰带");
			buy_four.setMy_collection_content("电热护肩背冬季保暖中老年男女护肩颈部热敷\n理疗信乐边纶布蓝+艾灸包");
			list.add(buy_four);
			
			MyCollectionDemo buy_five = new MyCollectionDemo();
			buy_five.setImg(R.drawable.the_red_outer_ear_thermometers);
			buy_five.setContent_title("红外耳机体温计");
			buy_five.setMy_collection_content("鼎力托玛琳自发热四季款护腰带(两用款)中\n号");
			list.add(buy_five);*/
		
	}
	
	OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.return_btn:
				finish();
				break;

			default:
				break;
			}
		}
	};

}
