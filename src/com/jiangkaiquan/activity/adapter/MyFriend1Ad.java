package com.jiangkaiquan.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * Created by jkqme on 2016/3/14.
 */
public class MyFriend1Ad extends BaseAdapter {
    ArrayList<Object>list;
    Context context;
    LayoutInflater inflater;
    public MyFriend1Ad() {

    }
    public MyFriend1Ad(ArrayList<Object>list,
            Context context) {
        this.context=context;
        this.list=list;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.i("getView",getCount()+"");
       if(view==null){
           Log.i("getView","adpter==null");
           view=inflater.inflate(R.layout.recomend_children,null);
       }else {   Log.i("getView","adpter==null");}

    return view;
    }
}
