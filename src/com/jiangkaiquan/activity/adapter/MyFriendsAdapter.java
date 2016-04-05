package com.jiangkaiquan.activity.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by jkqme on 2016/3/9.
 */
public class MyFriendsAdapter extends BaseExpandableListAdapter {
    private ArrayList<String> parent;
    private HashMap<String, ArrayList<Object>> map;
    private Context context;
    private LayoutInflater inflater;
    private Holder holder;

    public MyFriendsAdapter() {
    }

    public MyFriendsAdapter(ArrayList<String> parent,
                            HashMap<String, ArrayList<Object>> map,
                            Context context) {
        this.parent = parent;
        this.map = map;
        this.context = context;
        inflater = LayoutInflater.from(context);
    } 

    @Override
    public int getGroupCount() {
        return parent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return map.size();
    }

    @Override
    public Object getGroup(int i) {
        return parent.get(i);
    }

    @Override
    public Object getChild(int i, int i2) {
        return map.get(parent.get(i)).get(i2);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            holder = new Holder();
            view = inflater.inflate(R.layout.jiang_my_friend_ev, null);
            holder.text = (TextView) view.findViewById(R.id.ev_my_friend_tx);
            view.setTag(holder);

        } else {
            holder = (Holder) view.getTag();
        }

        holder.text.setText(this.parent.get(i));
        return view;
    }

    //没有chrildview
    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    class Holder {
        TextView text;
    }
}
