package com.jiangkaiquan.activity;

import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ExpandableListView;

/**
 * Created by jkqme on 2016/3/8.
 *
 */
public class Recomend extends Activity{
    private ExpandableListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recomend_indext_2);
        listView=new ExpandableListView(this);

    }
}
