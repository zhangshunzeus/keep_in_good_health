package com.zhangrong.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.zhangrong.adapter.MealnameListAdapter;
import com.zhangrong.example.MealnameInfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * Created by zhang on 2016/3/10.
 */
public class MealNameActivity extends Activity {
    private ListView listView;
    private ArrayList<MealnameInfo> infoList;
    private MealnameInfo info = new MealnameInfo();
    private MealnameListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meal_name_activity);
        infoList = new ArrayList<MealnameInfo>();
        listView = (ListView) findViewById(R.id.meal_name_list);
        loadiniv();
        adapter = new MealnameListAdapter(this, infoList);
        listView.setAdapter(adapter);
    }

    private void loadiniv() {
        for (int i = 1; i < 2; i++) {
            info.setMeal_name_show_image(R.drawable.show);
            info.setFood_iamge_one(R.drawable.ssdk_oks_logo_foursquare);
            info.setFood_iamge_two(R.drawable.ssdk_oks_logo_facebookmessenger);
            info.setFood_iamge_three(R.drawable.ssdk_oks_logo_flickr);
            info.setFood_text_one("每天三小时，只要求清楚8个点就行了");
            info.setFood_text_two("看过的知识，了解的知识，至少反复看三遍，采用跳跃式的方法");
            info.setFood_text_three("今天，你完成你的目标了吗，加油完成");
            info.setMeal_name_Liao_text("大神");
            info.setMeal_name_dosing_text("小神");
            info.setMeal_name_practice_text("加油，加油，加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "4加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油加油，加油加油，加油加油，加油加油，加油加油，加油" +
                    "加油，加油" +
                    "加油，加油加油，加油");
            infoList.add(info);

        }
    }
}
