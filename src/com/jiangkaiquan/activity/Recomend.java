package com.jiangkaiquan.activity;

import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;


import com.zhangwenbin.activity.PersonalCenterLoginName;

import com.zhangwenbin.activity.PersonalCenterLoginName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.view.View.OnClickListener;
import android.widget.TextView;


import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


import com.jiangkaiquan.activity.adapter.RecomendAdapter;


/**
 * Created by jkqme on 2016/3/8.
 * 合并了膳食
 */


public class Recomend extends Activity {
    private GridView gridView[] = new GridView[4];
    private int gid[] = {R.id.recomend1_fruit_gv, R.id.recomend_flish_gv, R.id.recomend_vgtable_gv, R.id.recomend_tea_gv};
    private int checkId[] = {R.id.recomend_chekmore_f_tx, R.id.recomend_chekmore_r_tx, R.id.recomend_chekmore_v_tx, R.id.recomend_chekmore_t_tx};
    private int foodTypId[] = {R.id.recomend1_fruit_tx, R.id.recomend1_flish_tx, R.id.recomend1_vgtable_tx, R.id.recomend1_tea_tx};
    private TextView text, recomend_recomend_tx, recomend_bttom_1_tx, recomend_bttom_2_tx, recomend_bttom_3_tx;
    private int curentDisplay = 4;
    private RecomendAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jiang_recomend_1);
        recomend_recomend_tx = (TextView) findViewById(R.id.recomend_recomend_tx);


        setContentView(R.layout.jiang_recomend_1);


        recomend_recomend_tx = (TextView) findViewById(R.id.recomend_recomend_tx);

        recomend_recomend_tx.setOnClickListener(click);

        recomend_bttom_1_tx = (TextView) findViewById(R.id.recomend_bttom_1_tx);
        recomend_bttom_1_tx.setOnClickListener(click);

        recomend_bttom_2_tx = (TextView) findViewById(R.id.recomend_bttom_2_tx);
        recomend_bttom_2_tx.setOnClickListener(click);

        recomend_bttom_3_tx = (TextView) findViewById(R.id.recomend_bttom_3_tx);
        recomend_bttom_3_tx.setOnClickListener(click);

    }


    OnClickListener click = new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.recomend_recomend_tx:
                    Intent intent = new Intent();
                    intent.setClass(Recomend.this, HomePageActivity.class);
                    startActivity(intent);
                    break;
                case R.id.recomend_bttom_1_tx:
                    Intent intent_homepage = new Intent();
                    intent_homepage.setClass(Recomend.this, HomePageActivity.class);
                    startActivity(intent_homepage);
                    break;
                case R.id.recomend_bttom_2_tx:
                    break;
                case R.id.recomend_bttom_3_tx:
                    Intent intent_personalCenterLoginName = new Intent();
                    intent_personalCenterLoginName.setClass(Recomend.this, PersonalCenterLoginName.class);
                    startActivity(intent_personalCenterLoginName);
                    break;
                default:
                    break;
            }
        }
    };


    /**
     * @i 列表项
     */
    private void getAdpter(int i) {
        ArrayList<Object> list = new ArrayList<Object>();
        adapter = new RecomendAdapter(list, this);
        gridView[i].setAdapter(adapter);
    }


}

