package com.jiangkaiquan.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jkqme on 2016/3/14.
 */
public class MyFriend1Ad extends BaseAdapter {
    ArrayList<HashMap<String,Object>>list;
    Context context;
    LayoutInflater inflater;
    public MyFriend1Ad() {

    }
    public MyFriend1Ad(ArrayList<HashMap<String,Object>>list,
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
        Holder holder;
        Log.i("getView",getCount()+"");
       if(view==null){
           Log.i("getView","adpter==null");
           holder=new Holder();
           view=inflater.inflate(R.layout.friend_child,null);
          holder.textView=(TextView)view.findViewById(R.id.friend_child_tx);
           holder.img=(ImageView)view.findViewById(R.id.friend_child_img);
            view.setTag(holder);
       }else {
           holder=(Holder)view.getTag();
           Log.i("getView","adpter==null");}
        holder.img.setImageDrawable(view.getResources().getDrawable((Integer)list.get(i).get("img")));
        holder.textView.setText((String)list.get(i).get("text"));


    return view;
    }
    class Holder{
        ImageView img;
        TextView textView;
    }
}
