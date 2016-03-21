package com.zhangwenbin.activity;

import java.util.ArrayList;

import com.zhangshun.adapter.MyRecordsAdapter;
import com.zhangshun.demo.MyRecordsDemo;
import com.zhangshun.keep_in_good_health.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
/*我的記錄中的fragment相對的待收貨頁面*/
@SuppressLint("NewApi")
public class MyRecordsFragmentReceive extends Fragment {
	ListView listView;
	ArrayList<MyRecordsDemo> data = new ArrayList<MyRecordsDemo>();
	MyRecordsAdapter adapter;
	@SuppressLint("NewApi")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		listView = (ListView)getView().findViewById(R.id.my_records_listview);
		getData();
		adapter = new MyRecordsAdapter(data,getActivity());
		listView.setAdapter(adapter);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.my_records_receive, container, false);
		
	}
	
	public void getData() {
		//for (int i = 0; i < 6; i++) {

			MyRecordsDemo myRecord = new MyRecordsDemo();
			myRecord.setImage(R.drawable.myrecords_picture_one);
			myRecord.setMy_records_shop_name("欧姆龙专卖店");
			myRecord.setMy_records_list_goodsstates("店家已发货");
			myRecord.setMy_records_content("OMRON欧姆龙红外耳饰体温计");
			myRecord.setMy_records_shop_type("TH457A ￥55.00");
			myRecord.setMy_records_shop_number("共一件商品  实付：");
			myRecord.setMy_records_shop_money("￥50.00");
			//myRecord.setMy_records_change_receiving(R.drawable.selector_change_receive);
			data.add(myRecord);
			MyRecordsDemo myRecord_one = new MyRecordsDemo();
			myRecord_one.setImage(R.drawable.myrecords_picture_two);
			myRecord_one.setMy_records_shop_name("鼎力托玛琳自然热四季款护腰带");
			myRecord_one.setMy_records_list_goodsstates("店家已发货");
			myRecord_one.setMy_records_content("鼎力托玛琳自然热四季款护腰带");
			myRecord_one.setMy_records_shop_type("领款中号 ￥184.00");
			myRecord_one.setMy_records_shop_number("共一件商品  实付：");
			myRecord_one.setMy_records_shop_money("￥180.00");
			//myRecord_one.setMy_records_change_receiving(R.drawable.no_check_change_receive);
			data.add(myRecord_one);
		//}

}
}
