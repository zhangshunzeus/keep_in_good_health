package com.zhangshun.adapter;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

public class MyRecordsAdapter extends BaseAdapter {
	ArrayList<MyRecordsDemo> data;
	Context context;
	LayoutInflater inflater;

	public MyRecordsAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MyRecordsAdapter(ArrayList<MyRecordsDemo> data, Context context) {
		this.context = context;
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@SuppressLint("InflateParams")
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolderMyRecords holder;
		if (view == null) {
			view = inflater.inflate(R.layout.my_records_list_item, null);
			holder = new ViewHolderMyRecords();
			holder.myrecordshopname = (TextView) view
					.findViewById(R.id.my_records_list_shopname);
			holder.myrecordgoodstates = (TextView) view
					.findViewById(R.id.my_records_list_goodsstates);
			holder.myrecordimage = (ImageView) view
					.findViewById(R.id.my_records_image);
			holder.myrecordcontent = (TextView) view
					.findViewById(R.id.my_records_content);
			holder.myrecordshoptype = (TextView) view
					.findViewById(R.id.my_records_shop_type);
			holder.myrecordshopnumber = (TextView) view
					.findViewById(R.id.my_records_shop_type);
			holder.myrecordshopmoney = (TextView) view
					.findViewById(R.id.my_records_shop_money);
			holder.myrecordchangereceive = (TextView) view
					.findViewById(R.id.my_records_change_receiving);
			view.setTag(holder);

		}
		holder = (ViewHolderMyRecords) view.getTag();
		MyRecordsDemo myRecordsDemo = (MyRecordsDemo) getItem(position);
		myRecordsDemo.setMy_records_shop_name(myRecordsDemo
				.getMy_records_shop_name());
		myRecordsDemo.setMy_records_list_goodsstates(myRecordsDemo
				.getMy_records_list_goodsstates());
		myRecordsDemo.setImage(myRecordsDemo.getImage());
		myRecordsDemo.setMy_records_content(myRecordsDemo
				.getMy_records_content());
		myRecordsDemo.setMy_records_shop_type(myRecordsDemo
				.getMy_records_shop_type());
		myRecordsDemo.setMy_records_shop_number(myRecordsDemo
				.getMy_records_shop_number());
		myRecordsDemo.setMy_records_shop_money(myRecordsDemo
				.getMy_records_shop_money());
		myRecordsDemo.setMy_records_change_receiving(myRecordsDemo
				.getMy_records_change_receiving());

		return view;
	}

	class ViewHolderMyRecords {
		ImageView myrecordimage;
		TextView myrecordcontent;
		TextView myrecordshopname;
		TextView myrecordgoodstates;
		TextView myrecordshoptype;
		TextView myrecordshopnumber;
		TextView myrecordshopmoney;
		TextView myrecordchangereceive;

	}

}
