package com.zhangrong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.zhangrong.adapter.SortFragmentRightAdapter;
import com.zhangrong.example.SortFragmentRightInfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * 这个fragment是，我的板块中的展示fragment，
 * 它加载的是我的板块布局
 *
 * @创建时间 2016-03-09
 */
public class SortFragmentRightTwo extends Fragment {

    private ArrayList<SortFragmentRightInfo> data = new ArrayList<SortFragmentRightInfo>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sortfragment_radio2_right, container, false);

        return view;
    }


    }








