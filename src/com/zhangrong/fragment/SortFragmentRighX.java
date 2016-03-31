package com.zhangrong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangshun.keep_in_good_health.R;
 
/**
 * 这个fragment是，我的板块中的展示fragment，
 * 它加载的是我的板块布局
 * @创建时间  2016-03-09
 */
public class SortFragmentRighX extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_fragment,container,false);
        return view;
    }
}
