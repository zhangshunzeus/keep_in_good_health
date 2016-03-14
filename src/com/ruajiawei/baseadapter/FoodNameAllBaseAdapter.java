package com.ruajiawei.baseadapter;

import java.util.ArrayList;

import com.ruanjiawei.demo.FoodNameAllInfo;
import com.zhangshun.keep_in_good_health.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodNameAllBaseAdapter extends BaseAdapter {
	ArrayList<FoodNameAllInfo> list;
	Context context;
	LayoutInflater inflater;

	public FoodNameAllBaseAdapter(ArrayList<FoodNameAllInfo> list, Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		inflater = LayoutInflater.from(context);
	}

	public void setData(ArrayList<FoodNameAllInfo> list) {
		this.list = list;
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int posistion) {
		// TODO Auto-generated method stub
		return list.get(posistion);
	}

	@Override
	public long getItemId(int posistion) {
		// TODO Auto-generated method stub

		return posistion;
	}

	@Override
	public View getView(int posistion, View convertView, ViewGroup patent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.more_listview, null);
			holder = new ViewHolder();
			holder.more_listview_image = (ImageView) convertView.findViewById(R.id.more_listview_image);
			holder.more_name_all_listview_title = (TextView) convertView
					.findViewById(R.id.more_name_all_listview_title);
			holder.more_name_all_listview_weight = (TextView) convertView
					.findViewById(R.id.more_name_all_listview_weight);
			holder.more_name_all_listview_giving = (TextView) convertView
					.findViewById(R.id.more_name_all_listview_giving);
			holder.more_name_all_listview_price = (TextView) convertView
					.findViewById(R.id.more_name_all_listview_price);
			holder.more_name_all_listview_nice = (TextView) convertView.findViewById(R.id.more_name_all_listview_nice);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		FoodNameAllInfo all = (FoodNameAllInfo) getItem(posistion);
		holder.more_listview_image.setImageResource(all.getMore_listview_image());
		holder.more_name_all_listview_title.setText(all.getMore_name_all_listview_title());
		holder.more_name_all_listview_weight.setText(all.getMore_name_all_listview_weight());
		holder.more_name_all_listview_giving.setText(all.getMore_name_all_listview_giving());
		holder.more_name_all_listview_price.setText(all.getMore_name_all_listview_price());
		holder.more_name_all_listview_nice.setText(all.getMore_name_all_listview_nice());

		return convertView;
	}

	class ViewHolder {
		ImageView more_listview_image;
		TextView more_name_all_listview_title;
		TextView more_name_all_listview_weight;
		TextView more_name_all_listview_giving;
		TextView more_name_all_listview_price;
		TextView more_name_all_listview_nice;
	}

}
