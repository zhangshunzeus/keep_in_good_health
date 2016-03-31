package com.zhangrong.fragment;

import com.ruanjiawei.activity.ShopDetailsActivity;
import com.zhangshun.activity.FruitActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.TodayEat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
<<<<<<< HEAD
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.ruanjiawei.activity.ShopDetailsActivity;
import com.zhangshun.activity.FruitActivity;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import com.zhangwenbin.activity.TodayEat;
=======
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
>>>>>>> f1cfbca0cd42de029120b1ccd5955b0c4e6f2830

/**这个类是 主页板块的主的fragment
 *  它加载的主页板块的布局
 * @创建时间   2016-03-10
 */
public class HomepageFragment extends Fragment {
	private ImageView fruit;
	private ImageView shopDetails;
	private ImageView todayEat;
	private Intent intent;
<<<<<<< HEAD
	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.home_page,container,false);
        fruit=(ImageView) view.findViewById(R.id.home_page_fruit);
        shopDetails=(ImageView) view.findViewById(R.id.shopDetails);
        todayEat=(ImageView) view.findViewById(R.id.todayEat);
        loadinivListener();
      
     
        return view;
    }

=======
	AutoCompleteTextView home_page_search;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_page, container, false);
		fruit = (ImageView) view.findViewById(R.id.home_page_fruit);
		shopDetails = (ImageView) view.findViewById(R.id.shopDetails);
		todayEat = (ImageView) view.findViewById(R.id.todayEat);
		home_page_search = (AutoCompleteTextView) view.findViewById(R.id.home_page_search);
		loadinivListener();
		return view;
	}
>>>>>>> f1cfbca0cd42de029120b1ccd5955b0c4e6f2830

	private void loadinivListener() {
		todayEat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intent=new Intent(getActivity(),TodayEat.class);
				startActivity(intent);
				
				
			}
		});
<<<<<<< HEAD
		  fruit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					intent=new Intent(getActivity(),FruitActivity.class);
					startActivity(intent);
					
				}
			});
	        shopDetails.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					intent=new Intent(getActivity(),ShopDetailsActivity.class);
					startActivity(intent);
					
				}
			});
		
=======

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
		
		home_page_search.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				home_page_search.setFocusable(true);
			}
		});

>>>>>>> f1cfbca0cd42de029120b1ccd5955b0c4e6f2830
	}

	
}
