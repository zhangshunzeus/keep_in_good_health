package com.zhangrong.fragment;

import com.ruanjiawei.activity.ShopDetailsActivity;
import com.zhangshun.activity.FruitActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.TodayEat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;

/**
 * 这个类是 主页板块的主的fragment 它加载的主页板块的布局
 * 
 * @创建时间 2016-03-10
 */
public class HomepageFragment extends Fragment {
	private ImageView fruit;
	private ImageView shopDetails;
	private ImageView todayEat;
	private Intent intent;

	AutoCompleteTextView home_page_search;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_page, container, false);
		fruit = (ImageView) view.findViewById(R.id.home_page_fruit);
		shopDetails = (ImageView) view.findViewById(R.id.shopDetails);
		todayEat = (ImageView) view.findViewById(R.id.todayEat);
		home_page_search = (AutoCompleteTextView) view
				.findViewById(R.id.home_page_search);
		loadinivListener();
		return view;
	}

	private void loadinivListener() {
		todayEat.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent = new Intent(getActivity(), TodayEat.class);
				startActivity(intent);

			}
		});

		fruit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent = new Intent(getActivity(), FruitActivity.class);
				startActivity(intent);

			}
		});
		shopDetails.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				intent = new Intent(getActivity(), ShopDetailsActivity.class);
				startActivity(intent);

			}
		});

		home_page_search.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!home_page_search.isFocusable()) {
					Log.i("Editex", "获取焦点");
					home_page_search.setFocusable(true);
					home_page_search.setFocusableInTouchMode(true);
					home_page_search.requestFocus();
				}

			}
		});

	}

}
