package com.zhangshun.activity;

import java.util.ArrayList;
import java.util.HashSet;
import com.zhangshun.adapter.TheShoppingCartAdapter;
import com.zhangshun.adapter.TheShoppingCartAdapter.ViewHolder;
import com.zhangshun.demo.TheShoppingCartDemo;
import com.zhangshun.keep_in_good_health.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;

public class TheShoppingCartActivity extends Activity {

	TheShoppingCartAdapter mAdapter;
	ListView mList;
	ArrayList<TheShoppingCartDemo> list = new ArrayList<TheShoppingCartDemo>();
	ImageView the_shopping_cart_return_btn;
	@SuppressWarnings("unused")
	private HashSet<String> itemSelected=new HashSet<String>();
	int checkNum;//记录选中的条目数量
	CheckBox Future_generations_all;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.the_shopping_cart_activity);
		mList = (ListView) findViewById (R.id.the_shopping_cart_list);
		mList.setOnItemClickListener(listener);
		//为Adapter准备数据
		getData();
		//实例化自定义的Adapter
		mAdapter = new TheShoppingCartAdapter(this,list);
		//绑定Adapter
		mList.setAdapter(mAdapter);
		
		the_shopping_cart_return_btn = (ImageView) findViewById (R.id.the_shopping_cart_return_btn);
		the_shopping_cart_return_btn.setOnClickListener(click);
		
		Future_generations_all = (CheckBox) findViewById (R.id.Future_generations);
		// 全选按钮的回调接口 
		/*Future_generations_all.setOnClickListener(new OnClickListener() { 
            @Override 
            public void onClick(View v) { 
                // 遍历list的长度，将MyAdapter中的map值全部设为true 
                for (int i = 0; i < list.size(); i++) { 
                	TheShoppingCartAdapter.getIsSelected().put(i, true); 
                } 
                // 数量设为list的长度 
                checkNum = list.size(); 
                // 刷新listview和TextView的显示 
                dataChanged(); 
            } 
        });*/
		
	}
	
	private void getData() {
		
		for(int i = 0; i < 3; i++){
			TheShoppingCartDemo buy = new TheShoppingCartDemo();
			buy.setImg(R.drawable.pu_er_tea);
			buy.setThe_shopping_title("");
			buy.setThe_shopping_content("");
			buy.setThe_shopping_number("");
			buy.setThe_price("");
			list.add(buy);
		}
		
	}
	
	OnClickListener click = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.the_shopping_cart_return_btn:
				finish();
				break;
			case R.id.Future_generations_all:
			
				break;
			default:
				break;
			}
		}
	};
	
	OnItemClickListener listener = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
			// TODO Auto-generated method stub
			//取得ViewHolder对象，这样就省去了通过层层的findViewBuId去实例化我需要的checkbox实力的步骤
			ViewHolder holder = (ViewHolder) arg1.getTag();
			//改变CheckBox的状态
			holder.Future_generations.toggle();
			//将CheckBox的选中状况记录下来
			TheShoppingCartAdapter.getIsSelected().put(arg2,holder.Future_generations.isChecked());
			if (holder.Future_generations.isChecked() == true){
				checkNum++;
			}else{
				checkNum--;
			}
		}
	};
	
	//刷新listview的显示
	private void dataChanged(){
		//通知listview刷新
		mAdapter.notifyDataSetChanged();
	}
	
}





