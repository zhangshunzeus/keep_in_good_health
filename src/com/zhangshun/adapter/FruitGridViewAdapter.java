package com.zhangshun.adapter;

import com.zhangshun.keep_in_good_health.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitGridViewAdapter extends BaseAdapter {

	private String data[] ;
	private int imgId[] ;
	private Context context ;
	private LayoutInflater inflater ;

	public FruitGridViewAdapter(Context context, String[] data, int[] imgId) {
		// TODO Auto-generated constructor stub
		super();
		this.data = data;
		this.imgId = imgId;
		this.context = context;

		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.fruit_gridview, null);
			holder = new Holder();
			holder.tv = (TextView) convertView.findViewById(R.id.describe);
			holder.img = (ImageView) convertView.findViewById(R.id.gridview_img);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();

		}
		// 为holder中的tv和img设置内容
		holder.tv.setText(data[position]);
		holder.img.setImageResource(imgId[position]);
		// 注意 默认为返回null,必须得返回convertView视图
		return convertView;
	}

	private class Holder {

		public ImageView img;
		public TextView tv;

	}

}
