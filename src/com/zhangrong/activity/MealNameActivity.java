package com.zhangrong.activity;

import java.util.ArrayList;

import com.zhangrong.adapter.MealnameListAdapter;
import com.zhangrong.example.MealnameInfo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

/**
 * Created by zhang on 2016/3/10.
 */
public class MealNameActivity extends Activity {
    private ListView listView;
    private ArrayList<MealnameInfo> infoList;
    private MealnameInfo info = new MealnameInfo();
    private MealnameListAdapter adapter;
    ImageView meal_name_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_name_activity);
        infoList = new ArrayList<MealnameInfo>();
        listView = (ListView) findViewById(R.id.meal_name_list);
        loadiniv();
        adapter = new MealnameListAdapter(this, infoList);
        listView.setAdapter(adapter);
        
        meal_name_back = (ImageView) findViewById (R.id.meal_name_back);
        meal_name_back.setOnClickListener(clcik);
        
    }

    private void loadiniv() {
        for (int i = 1; i < 2; i++) {
            info.setMeal_name_show_image(R.drawable.meal_name_show_image);
            info.setFood_iamge_one(R.drawable.food_iamge_one);
            info.setFood_iamge_two(R.drawable.food_iamge_two);
            info.setFood_text_one_title("草莓");
            info.setFood_text_one_text("草莓具有帮助消耗的功效，草莓还可以巩固牙龈，润泽喉部。");
             info.setFood_text_two_title("燕麦片");
            info.setFood_text_two_text("燕麦可以改善血液循环，缓解生活工作带来的压力。");
            info.setMeal_name_Liao_text("草莓100g，燕窝片100g.");
            info.setMeal_name_dosing_text("荷兰乳牛乳酸牛奶200ml，水800ml。");
            info.setMeal_name_practice_text("1.先将草莓洗干净，并切成丁庄。");
            infoList.add(info);

        }
    }
    public void dian(View view){
    	finish();

    }
    
    OnClickListener clcik = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.meal_name_back:
				finish();
				break;

			default:
				break;
			}
		}
	};
    
}
