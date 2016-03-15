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
			viewHodler.img = (ImageView) convertView.findViewById(R.id.pu_er_tea);
			viewHodler.the_shopping_title = (TextView) convertView.findViewById(R.id.the_shopping_title);
			viewHodler.the_shopping_content = (TextView) convertView.findViewById(R.id.the_shopping_content);
			viewHodler.the_shopping_number = (TextView) convertView.findViewById(R.id.the_shopping_number);
			viewHodler.The_price = (TextView) convertView.findViewById(R.id.The_price);
			convertView.setTag(viewHodler);
		}
		
		viewHodler = (ViewHolder) convertView.getTag();
		TheShoppingCartDemo theShoppingCartDemo = (TheShoppingCartDemo) getItem(position);
		theShoppingCartDemo.setImg(theShoppingCartDemo.getImg());
		theShoppingCartDemo.setThe_shopping_title(theShoppingCartDemo.getThe_shopping_title());
		theShoppingCartDemo.setThe_shopping_content(theShoppingCartDemo.getThe_shopping_content());
		theShoppingCartDemo.setThe_shopping_number(theShoppingCartDemo.getThe_shopping_number());
		theShoppingCartDemo.setThe_price(theShoppingCartDemo.getThe_price());
		return convertView;
	}
	
	class ViewHolder{

		public TextView The_price;
		public TextView the_shopping_number;
		public TextView the_shopping_content;
		public TextView the_shopping_title;
		public ImageView img;
		
	}

}
