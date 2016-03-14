package com.zhangrong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhangrong.example.SortFragmentLeftinfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * Created by zhang on 2016/3/10.
 */
public class SortFragmentLeftAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SortFragmentLeftinfo> data;

    public SortFragmentLeftAdapter(Context context,ArrayList<SortFragmentLeftinfo> data){
        this.context=context;
        this.data=data;

    }
    @Override
    public int getCount() {
        return data==null?0:data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).
                    inflate(R.layout.sortfragment_left_listview_item,null);
            viewHolder.tv= (TextView) convertView.findViewById(R.id.sort_left_text1);
            convertView.setTag(viewHolder);


        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //进行对控件进行设置
        SortFragmentLeftinfo info=data.get(position);
        viewHolder.tv.setText(info.getSort_left_text1());

        return convertView;
    }
    public class ViewHolder{
        private TextView tv;

    }
}
