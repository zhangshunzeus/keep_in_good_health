package com.zhangshun.adapter;

import java.util.ArrayList;

import com.zhangshun.adapter.MyCollectionAdapter.ViewHolder;
import com.zhangshun.demo.TheShoppingCartDemo;
import com.zhangshun.keep_in_good_health.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TheShoppingCartAdapter extends BaseAdapter {

	Context context;
	LayoutInflater mInflater;
	ArrayList<TheShoppingCartDemo> list;
	
	public TheShoppingCartAdapter() {
		// TODO Auto-generated constructor stub
	}
	
	public TheShoppingCartAdapter(Context context,ArrayList<TheShoppingCartDemo>list){
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHodler;
		if(convertView == null){
			convertView = mInflater.inflate(R.layout.the_shopping_cart_list, null);
			viewHodler = new ViewHolder();
			viewHodler.img = (TextView) convertView.findViewById(R.id.img);
			viewHodler.my_collection_content = (TextView) convertView.findViewById(R.id.my_collection_content);
			viewHodler.content_list_btn = (ImageView) convertView.findViewById(R.id.content_list_btn);
			convertView.setTag(viewHodler);
		}
		
		viewHodler = (ViewHolder) convertView.getTag();
		TheShoppingCartDemo theShoppingCartDemo = (TheShoppingCartDemo) getItem(position);
		theShoppingCartDemo.setImg(theShoppingCartDemo.getImg());
		theShoppingCartDemo.setMy_collection_content(theShoppingCartDemo.getMy_collection_content());
		theShoppingCartDemo.setContent_list_btn(theShoppingCartDemo.getContent_list_btn());
		return convertView;
	}
	
	class ViewHolder{

		public ImageView content_list_btn;
		public TextView my_collection_content;
		public TextView img;
		
	}

}
