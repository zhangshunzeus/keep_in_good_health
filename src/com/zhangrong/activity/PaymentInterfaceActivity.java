package com.zhangrong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.zhangshun.keep_in_good_health.R;

import c.b.BP;
import c.b.PListener;

/**
 * 负责支付的类 ，，王颖支付未完成
 * 
 * @author jkqme
 * 
 */

public class PaymentInterfaceActivity extends Activity implements
		OnClickListener {
	private ImageView payment_back;
	private LinearLayout pay_line1;
	private LinearLayout pay_line2;
	private LinearLayout pay_line3;

	Double sun;

	private String shopName = null;
	
    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BP.init(this, "dd89992e72fed0a3878494fc468a3c92");
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.payment_interface_activity);
        payment_back=(ImageView) findViewById(R.id.payment_back);
        pay_line1=(LinearLayout) findViewById(R.id.pay_line1);
        pay_line2=(LinearLayout) findViewById(R.id.pay_line2);
        pay_line3=(LinearLayout) findViewById(R.id.pay_line3);
        pay_line1.setOnClickListener(this);
        pay_line2.setOnClickListener(this);
        pay_line3.setOnClickListener(this);
        payment_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PaymentInterfaceActivity.this,
						TheShopingCartActivityGG.class);
				startActivity(intent);

			}
		});
		Intent intent = getIntent();
		// StringBuffer buffe=new StringBuffer();
		//
		// arg=intent.getStringArrayExtra("shoppName");

		sun = intent.getDoubleExtra("shopSum", 0);
		shopName = intent.getStringExtra("shoppName");

		Log.i("pay", "PAY界面" + sun);
		// for(int i=0;i<arg.length;i++){
		// buffe.append(arg[i]+"、");
		//
		// }
		// Log.i("pay",buffe.toString());
		Log.i("pay", "PAY界面的Name" + shopName);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.pay_line1:
			Toast.makeText(this, "请等待，您正在用支付宝进行支付", Toast.LENGTH_SHORT).show();

			payAilPAY();

			break;
		case R.id.pay_line2:
			Toast.makeText(this, "请等待，您正在用微信进行支付", Toast.LENGTH_SHORT).show();
			payWXPAY();

			break;
		case R.id.pay_line3:
			Toast.makeText(this, "正在开发，请等待", Toast.LENGTH_SHORT).show();

			break;

		default:
			break;
		}

	}

	private void payWXPAY() {
		BP.pay(PaymentInterfaceActivity.this, "购买商品是" + shopName, shopName,
				sun, false, new PListener() {

					@Override
					public void unknow() {
						// TODO Auto-generated method stub

					}

					@Override
					public void succeed() {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付成功,返回到购物车", Toast.LENGTH_SHORT).show();
						finish();

					}

					@Override
					public void orderId(String arg0) {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付订单id：" + arg0, Toast.LENGTH_SHORT).show();

					}

					@Override
					public void fail(int arg0, String arg1) {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付失败了，请从新支付", Toast.LENGTH_SHORT).show();

					}
				});

	}

	// 阿里支付
	private void payAilPAY() {
		BP.pay(PaymentInterfaceActivity.this, "购买商品是" + shopName, shopName,
				sun, true, new PListener() {

					@Override
					public void unknow() {
						// TODO Auto-generated method stub

					}

					@Override
					public void succeed() {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付成功,返回到购物车", Toast.LENGTH_SHORT).show();
						finish();

					}

					@Override
					public void orderId(String arg0) {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付订单id：" + arg0, Toast.LENGTH_SHORT).show();

					}

					@Override
					public void fail(int arg0, String arg1) {
						Toast.makeText(PaymentInterfaceActivity.this,
								"支付失败了，请从新支付", Toast.LENGTH_SHORT).show();

					}
				});

	}

}
