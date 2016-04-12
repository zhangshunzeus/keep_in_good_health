package com.zhangrong.fragment;

import com.ruanjiawei.activity.ShopDetailsActivity;
import com.zhangshun.activity.FruitActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.TodayEat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
	private AutoCompleteTextView autoCompleteTextView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.home_page, container, false);
		fruit = (ImageView) view.findViewById(R.id.home_page_fruit);
		shopDetails = (ImageView) view.findViewById(R.id.shopDetails);
		todayEat = (ImageView) view.findViewById(R.id.todayEat);
		autoCompleteTextView = (AutoCompleteTextView) view
				.findViewById(R.id.home_page_search); 
       // initAutoComplete("history", autoCompleteTextView); 
        ImageView search = (ImageView) view.findViewById(R.id.iv_search);  
     /*   search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 saveHistory("history", autoCompleteTextView);
			}
		}); */
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

		autoCompleteTextView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if (!autoCompleteTextView.isFocusable()) {
					Log.i("Editex", "获取焦点");
					autoCompleteTextView.setFocusable(true);
					autoCompleteTextView.setFocusableInTouchMode(true);
					autoCompleteTextView.requestFocus();
				}

			}
		});

	}

	/** 
     * 把指定AutoCompleteTextView中内容保存到sharedPreference中指定的字符段 
     *  
     * @param  
     *            保存在sharedPreference中的字段名 
     * @param autoCompleteTextView 
     *            要操作的AutoCompleteTextView 
     */  
 /*   private void saveHistory(String field,  
            AutoCompleteTextView autoCompleteTextView) {  
        String text = autoCompleteTextView.getText().toString();  
        SharedPreferences sp = getSharedPreferences("network_url", 0);  
        String longhistory = sp.getString(field, "nothing");  
        if (!longhistory.contains(text + ",")) {  
            StringBuilder sb = new StringBuilder(longhistory);  
            sb.insert(0, text + ",");  
            sp.edit().putString("history", sb.toString()).commit();  
        }  
    }  
    
    private SharedPreferences getSharedPreferences(String string, int i) {
		// TODO Auto-generated method stub

		return null;
	}*/

	/** 
     * 初始化AutoCompleteTextView，最多显示5项提示，使 AutoCompleteTextView在一开始获得焦点时自动提示 
     *  
     * @param 
     *            保存在sharedPreference中的字段名 
     * @param autoCompleteTextView 
     *            要操作的AutoCompleteTextView 
     */  
  /*  private void initAutoComplete(String field,  
            AutoCompleteTextView autoCompleteTextView) {  
        SharedPreferences sp = getSharedPreferences("network_url", 0);  
        String longhistory = sp.getString("history", "nothing");  
        String[] histories = longhistory.split(",");  
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),  
                android.R.layout.simple_dropdown_item_1line, histories);  
        // 只保留最近的50条的记录  
        if (histories.length > 50) {  
            String[] newHistories = new String[50];  
            System.arraycopy(histories, 0, newHistories, 0, 50);  
            adapter = new ArrayAdapter<String>(getActivity(),  
                    android.R.layout.simple_dropdown_item_1line, newHistories);  
        }  
        autoCompleteTextView.setAdapter(adapter);  
        autoCompleteTextView  
                .setOnFocusChangeListener(new OnFocusChangeListener() {  
                    @Override  
                    public void onFocusChange(View v, boolean hasFocus) {  
                        AutoCompleteTextView view = (AutoCompleteTextView) v;  
                        if (hasFocus) {  
                            view.showDropDown();  
                        }  
                    }  
                });  
    }*/

}
