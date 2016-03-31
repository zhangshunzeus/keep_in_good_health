package com.zhangrong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.zhangrong.adapter.SortFragmentLeftAdapter;
import com.zhangrong.example.SortFragmentLeftinfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * 这个fragment是，我的板块中的展示fragment，
 * 它加载的是我的板块布局
 *
 * @创建时间 2016-03-09
 */
public class SortFragmentLeft extends Fragment {
    private ListView lv;
    private ArrayList<SortFragmentLeftinfo> info = new ArrayList<SortFragmentLeftinfo>();
    private SortFragmentLeftinfo data;
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sortfragment_left, container, false);
        lv = (ListView) view.findViewById(R.id.sortfragment_left_listview);
        SortFragmentLeftAdapter adapter = new SortFragmentLeftAdapter(getActivity(), info);
        loadinivData();
        lv.setAdapter(adapter);
        Log.i("jjj", "执行到Left的setAdapter的后面");
        return view;
    }

    private void loadinivData() {
        for (int i = 0; i < 10; i++) {
            data=new SortFragmentLeftinfo();
            data.setSort_left_text1("春季饮食");
            info.add(data);

        }
        Log.i("jjj", "输出list的数据" + info);
    }



}
