package com.zhangrong.activity;

import java.util.ArrayList;

import com.zhangrong.adapter.ListPayAdapter;
import com.zhangrong.example.ListPayInfo;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 购物车的类
 * 
 * @author jkqme
 * 
 */
public class TheShopingCartActivityGG extends Activity {

	private CheckBox cheak;
	private Double shoppSUM = 0.00;
	String shoppName;
	StringBuilder builder = new StringBuilder();
	private ListPayAdapter adapter;
	private ListView lv;// 购物车中的listview
	private TextView text1, text2;
	private ArrayList<ListPayInfo> data = new ArrayList<ListPayInfo>();
	private ListPayInfo info;
	private TextView radio5;
	private TextView radio4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.theshopingcat_activity);
		cheak = (CheckBox) findViewById(R.id.radio1);
		lv = (ListView) findViewById(R.id.listview);
		radio5 = (TextView) findViewById(R.id.radio5);
		text1 = (TextView) findViewById(R.id.text1);
		text2 = (TextView) findViewById(R.id.textTwo);
		radio4 = (TextView) findViewById(R.id.radio4);
		radio4.setOnClickListener(listener);
		// 准备数据
		int[] imageData = { R.drawable.commodity_imger1,
				R.drawable.commodity_imger2, R.drawable.commodity_imger3 };
		double[] price = { 0.01, 0.02, 0.03 };
		int[] shopping_number = { 1, 3, 2 };
		String[] shopping_name = { "金银花茶", "蜜蜂糖", "养生健康茶" };
		String[] shopping_content = { "金银花茶价格是28.0元", "蜜蜂糖是30元一罐", "健康茶是25.6元" };
		BroadcastReceiver receiver;
		IntentFilter filter = new IntentFilter();
		filter.addAction("sss");
		registerReceiver(mRe, filter);
		for (int i = 0; i < shopping_name.length; i++) {
			info = new ListPayInfo();
			info.setPu_er_tea(imageData[i]);
			info.setThe_shopping_title(shopping_name[i]);
			info.setThe_shopping_content(shopping_content[i]);
			info.setThe_price(price[i]);
			info.setThe_shopping_number(shopping_number[i]);
			info.setCheck(false);
			data.add(info);
		}
		adapter = new ListPayAdapter(this, data);
		lv.setAdapter(adapter);
	}

	/**
	 * 监听
	 */
	private OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.radio4:
				dian(v);
				break;

			default:
				break;
			}
		}
	};

	public void box_all(View view) {

		int coumu = 0;
		double price = 0;
		for (int i = 0; i < adapter.getCount(); i++) {
			adapter.isSelected.set(i, cheak.isChecked());
			coumu = i + 1;
			price = price + adapter.getData().get(i).getThe_price();
			builder.append("" + adapter.getData().get(i).getItem_title());

		}
		if (cheak.isChecked()) {
			Log.i("pay", "" + price);

			radio5.setText("" + coumu);
			text1.setText("合计：￥" + price);
			text2.setText("总额：￥" + price);
			shoppSUM = price;
			shoppName = builder.toString();
		} else {
			radio5.setText("");
			text1.setText("合计：￥0.00");
			text2.setText("总额：￥0.00");
		}
		lv.setAdapter(adapter);

	}

	private final BroadcastReceiver mRe = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action.equals("sss")) {
				Double sun = intent.getDoubleExtra("pices", 0.00);
				int index = intent.getIntExtra("index", 0);
				shoppName = intent.getStringExtra("shopName");
				// String[] shoppName=intent.getStringArrayExtra("shopName");
				// StringBuffer buffer=new StringBuffer();
				// buffer.append(shoppName);

				shoppSUM = sun;
				text1.setText("合计：￥" + sun);
				text2.setText("总额：￥" + sun);
				radio5.setText("" + index);
				// Log.i("pay",""+ buffer.toString());
			}
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(mRe);
	}

	public void dian(View view) {
		// ArrayList<ListPayInfo> info=adapter.getData();
		// String[] shoppName=new String[info.size()];

		// for(int i=0;i<info.size();i++){
		// shoppName[i]=info.get(i).getThe_shopping_title();
		//
		// }
		if (shoppSUM > 0) {
			Intent intent = new Intent(TheShopingCartActivityGG.this,
					PaymentInterfaceActivity.class);
			intent.putExtra("shoppName", shoppName);
			intent.putExtra("shopSum", shoppSUM);

			startActivity(intent);
		} else {
			Toast.makeText(this, "请你选择要选购的商品", Toast.LENGTH_SHORT).show();
		}

	}

}
