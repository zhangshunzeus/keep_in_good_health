package com.zhangshun.adapter;

import java.util.ArrayList;

import com.zhangshun.demo.ShopCollectionDemo;
import com.zhangshun.keep_in_good_health.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShopCollectionAdapter extends BaseAdapter {
	ArrayList<ShopCollectionDemo> data;
	Context context;
	LayoutInflater inflater;

	public ShopCollectionAdapter() {
		// TODO Auto-generated constructor stub
	}

	public ShopCollectionAdapter(ArrayList<ShopCollectionDemo> data,
			Context context) {
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
		ViewHolderShopCollect viewHolder;
		if (view == null) {
			view = inflater.inflate(R.layout.shop_collection_list_item, null);
			viewHolder = new ViewHolderShopCollect();
			viewHolder.shopCollectionImage = (ImageView) view
					.findViewById(R.id.shop_collection_item_image);
			viewHolder.shopCollectionShopName = (TextView) view
					.findViewById(R.id.shop_collection_item_shopname);
			viewHolder.shopCollectionMoneyImage = (ImageView) view
					.findViewById(R.id.shop_collection_item_moneyimage);
			viewHolder.shopCollectionShopMoney = (TextView) view
					.findViewById(R.id.shop_collection_item_money);
			viewHolder.shopCollectionIntent = (ImageView) view
					.findViewById(R.id.shop_collection_item_intent);
			view.setTag(viewHolder);
		}
		viewHolder = (ViewHolderShopCollect) view.getTag();
		ShopCollectionDemo shopCollectionDemo = (ShopCollectionDemo) getItem(position);
		shopCollectionDemo.setShopCollectionImage(shopCollectionDemo
				.getShopCollectionImage());
		shopCollectionDemo.setShopCollectionShopName(shopCollectionDemo
				.getShopCollectionShopName());
		shopCollectionDemo.setShopCollectionMoneyImage(shopCollectionDemo
				.getShopCollectionMoneyImage());
		shopCollectionDemo.setShopCollectionMoney(shopCollectionDemo
				.getShopCollectionMoney());
		shopCollectionDemo.setShopCollectionIntent(shopCollectionDemo
				.getShopCollectionIntent());

		return view;
	}

	class ViewHolderShopCollect {
		ImageView shopCollectionImage;
		TextView shopCollectionShopName;
		ImageView shopCollectionMoneyImage;
		TextView shopCollectionShopMoney;
		ImageView shopCollectionIntent;

	}

}
