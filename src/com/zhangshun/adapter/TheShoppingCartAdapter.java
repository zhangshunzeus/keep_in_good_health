package com.zhangshun.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.zhangshun.demo.TheShoppingCartDemo;
import com.zhangshun.keep_in_good_health.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class TheShoppingCartAdapter extends BaseAdapter {

    private TheShoppingCartAdapter mAdapter;
	//上下文
	Context context;
	//用来导入布局
	LayoutInflater mInflater;
	//存储数据的list
	ArrayList<TheShoppingCartDemo> list;
	private Object viewHodle;
	
	public TheShoppingCartAdapter() {
		// TODO Auto-generated constructor stub
	} 
	//构造器
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
			//导入布局并赋值给convertview
			convertView = mInflater.inflate(R.layout.the_shopping_cart_list, null);
			//获得ViewHolder对象
			viewHodler = new ViewHolder();
			viewHodler.img = (ImageView) convertView.findViewById(R.id.shopping_img);
			viewHodler.the_shopping_title = (TextView) convertView.findViewById(R.id.the_shopping_title);
			viewHodler.the_shopping_content = (TextView) convertView.findViewById(R.id.the_shopping_content);
			viewHodler.the_shopping_number = (TextView) convertView.findViewById(R.id.the_shopping_number);
			viewHodler.The_price = (TextView) convertView.findViewById(R.id.The_price);
			viewHodler.Future_generations = (CheckBox) convertView.findViewById(R.id.Future_generations);
			//为view设置标签
			convertView.setTag(viewHodler);
		}
		//取出holder
		viewHodler = (ViewHolder) convertView.getTag();
		//设置list中的数据的显示
		TheShoppingCartDemo theShoppingCartDemo = (TheShoppingCartDemo) getItem(position);
		theShoppingCartDemo.setImg(theShoppingCartDemo.getImg());
		theShoppingCartDemo.setThe_shopping_title(theShoppingCartDemo.getThe_shopping_title());
		theShoppingCartDemo.setThe_shopping_content(theShoppingCartDemo.getThe_shopping_content());
		theShoppingCartDemo.setThe_shopping_number(theShoppingCartDemo.getThe_shopping_number());
		theShoppingCartDemo.setThe_price(theShoppingCartDemo.getThe_price());
		
		return convertView;
	}
	
	public class ViewHolder{

		public CheckBox Future_generations;
		public TextView The_price;
		public TextView the_shopping_number;
		public TextView the_shopping_content;
		public TextView the_shopping_title;
		public ImageView img;
		public TextView tvName;    
        public ImageButton deleteButton;    
		
	}

}
