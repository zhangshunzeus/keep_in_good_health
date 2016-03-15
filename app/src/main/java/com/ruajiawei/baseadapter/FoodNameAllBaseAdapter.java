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
			convertView = inflater.inflate(R.layout.food_name_all_listview, null);
			holder = new ViewHolder();
			holder.food_name_all_listview_image = (ImageView) convertView
					.findViewById(R.id.food_name_all_listview_image);
			holder.food_name_all_listview_text = (TextView) convertView.findViewById(R.id.food_name_all_listview_text);
			convertView.setTag(holder);
		}
		holder = (ViewHolder) convertView.getTag();
		FoodNameAllInfo all = (FoodNameAllInfo) getItem(posistion);
		holder.food_name_all_listview_image.setImageResource(all.getFood_name_all_listview_image());
		holder.food_name_all_listview_text.setText(all.getFood_name_all_listview_text());
		return convertView;
	}

	class ViewHolder {
		ImageView food_name_all_listview_image;
		TextView food_name_all_listview_text;
	}

}
