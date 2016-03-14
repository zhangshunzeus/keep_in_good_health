package com.zhangrong.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangshun.keep_in_good_health.R;

/**
 * 这个类是 主页板块的主的fragment
 * 它加载的主页板块的布局
 *
 * @创建时间 2016-03-10
 */
public class SortFragment extends android.support.v4.app.Fragment {
    private android.support.v4.app.FragmentManager manager;
    private android.support.v4.app.FragmentTransaction tran;
    private SortFragmentLeft left;
    private SortFragmentRight righet;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sort_fragment, container, false);
        inivFragment();
        return view;
    }

    private void inivFragment() {
        manager = getFragmentManager();
        tran = manager.beginTransaction();

        left = new SortFragmentLeft();
        righet = new SortFragmentRight();
        tran.add(R.id.sortfragment_left_line, left);
        tran.add(R.id.sortfragment_regit_line, righet);

        tran.commit();


    }
}
