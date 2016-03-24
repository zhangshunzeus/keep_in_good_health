package com.zhangshun.adapter;

import java.util.ArrayList;
import com.zhangshun.demo.MyCollectionDemo;
import com.zhangshun.keep_in_good_health.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyCollectionAdapter extends BaseAdapter {
	
	Context context;
	LayoutInflater mInflater;
	ArrayList<MyCollectionDemo>list;

	public MyCollectionAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public MyCollectionAdapter(Context context,ArrayList<MyCollectionDemo>list){
		this.context = context;
		this.list = list;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHodler;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.my_collection_listview, null);
			viewHodler = new ViewHolder();
			viewHodler.img = (TextView) convertView.findViewById(R.id.img);
			viewHodler.content_title = (TextView) convertView.findViewById(R.id.content_title);
			viewHodler.my_collection_content = (TextView) convertView.findViewById(R.id.my_collection_content);
			viewHodler.content_list_btn = (ImageView) convertView.findViewById(R.id.content_list_btn);
			convertView.setTag(viewHodler);
		}
		viewHodler = (ViewHolder) convertView.getTag();
		MyCollectionDemo myCollectionDemo = (MyCollectionDemo) getItem(position);
		myCollectionDemo.setImg(myCollectionDemo.getImg());
		myCollectionDemo.setContent_title(myCollectionDemo.getContent_title());
		myCollectionDemo.setMy_collection_content(myCollectionDemo.getMy_collection_content());
		myCollectionDemo.setContent_list_btn(myCollectionDemo.getContent_list_btn());
		return convertView;
	}
	
	class ViewHolder {

		public TextView img;
		public ImageView content_list_btn;
		public TextView my_collection_content;
		public TextView content_title;
		
	}

}
