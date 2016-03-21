package com.zhangshun.adapter;

import java.util.ArrayList;
import java.util.Map;

import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;

import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecordsAdapter extends BaseAdapter {
	ArrayList<MyRecordsDemo> data;
	Context context;
	LayoutInflater inflater;
	Map<integer, integer> selector;

	public MyRecordsAdapter() {
		// TODO Auto-generated constructor stub
	}

	public MyRecordsAdapter(ArrayList<MyRecordsDemo> data, Context context) {
		this.data = data;
		this.context = context;

		inflater = LayoutInflater.from(context);
	}

	public void setData(ArrayList<MyRecordsDemo> data) {
		this.data = data;
		this.notifyDataSetChanged();

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
	public View getView(final int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub

		ViewHolderMyRecords holder = null;
		if (view == null) {
			view = inflater.inflate(R.layout.my_records_list_item, null);
			holder = new ViewHolderMyRecords();

			holder.myrecordshopname = (TextView) view.findViewById(R.id.my_records_list_shopname);
			holder.myrecordgoodstates = (TextView) view.findViewById(R.id.my_records_list_goodsstates);
			holder.myrecordimage = (ImageView) view.findViewById(R.id.my_records_image);
			holder.myrecordcontent = (TextView) view.findViewById(R.id.my_records_content);
			holder.myrecordshoptype = (TextView) view.findViewById(R.id.my_records_shop_type);
			holder.myrecordshopnumber = (TextView) view.findViewById(R.id.my_records_shop_type);
			holder.myrecordshopmoney = (TextView) view.findViewById(R.id.my_records_shop_money);
			holder.myrecordchangereceive = (CheckBox) view.findViewById(R.id.my_records_change_receiving);
			
			view.setTag(holder);
			holder.myrecordchangereceive.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Toast.makeText(context, "点击确认收货", Toast.LENGTH_SHORT).show();
					CheckBox checkBox=(CheckBox)arg0;
					data.get(position).checked=checkBox.isChecked();
				}				
			});
		}
		
		if (position == 1) {
			holder = (ViewHolderMyRecords) view.getTag();
			MyRecordsDemo myRecordsDemo_one = data.get(position);
			holder.myrecordshopname.setText(myRecordsDemo_one.getMy_records_shop_name());
			holder.myrecordgoodstates.setText(myRecordsDemo_one.getMy_records_list_goodsstates());
			holder.myrecordimage.setImageResource(myRecordsDemo_one.getImage());
			holder.myrecordcontent.setText(myRecordsDemo_one.getMy_records_content());
			holder.myrecordshoptype.setText(myRecordsDemo_one.getMy_records_shop_type());
			holder.myrecordshopnumber.setText(myRecordsDemo_one.getMy_records_shop_number());
			holder.myrecordshopmoney.setText(myRecordsDemo_one.getMy_records_shop_money());
			
		}
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
		CheckBox myrecordchangereceive;
		CheckBox myrecordchangereceiveyes;
		

	}

}
