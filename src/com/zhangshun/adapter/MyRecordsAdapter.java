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

public class MyRecordsAdapter extends BaseAdapter{
	ArrayList<MyRecordsDemo> data;
	Context context;
	LayoutInflater inflater;
	
	public MyRecordsAdapter() {
		// TODO Auto-generated constructor stub
	}
	public MyRecordsAdapter(ArrayList<MyRecordsDemo> data,Context context){
		this.context=context;
		this.data=data;
		inflater=LayoutInflater.from(context);
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
		if (view==null) {
			view=inflater.inflate(R.layout.my_records_list_item, null);
			holder=new ViewHolderMyRecords();
			holder.myrecordimage=(ImageView)view.findViewById(R.id.my_records_image);
			holder.myrecordtitle=(TextView)view.findViewById(R.id.my_records_title);
			holder.myrecordcontent=(TextView)view.findViewById(R.id.my_records_content);
			holder.myrecordintent=(ImageView)view.findViewById(R.id.my_records_intent);
			view.setTag(holder);
			
		}
		holder=(ViewHolderMyRecords)view.getTag();
		MyRecordsDemo myRecordsDemo=(MyRecordsDemo)getItem(position);
		myRecordsDemo.setImage(myRecordsDemo.getImage());
		myRecordsDemo.setMy_records_title(myRecordsDemo.getMy_records_title());
		myRecordsDemo.setMy_records_content(myRecordsDemo.getMy_records_content());
		myRecordsDemo.setMy_records_intent(myRecordsDemo.getMy_records_intent());
		
		return view;
	}
	
	class ViewHolderMyRecords{
		ImageView myrecordimage;
		TextView myrecordtitle;
		TextView myrecordcontent;
		ImageView myrecordintent;
		
	}
	

}
