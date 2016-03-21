package com.zhangrong.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;


public class PaymentInterfaceActivity extends Activity {
	private ImageView payment_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_interface_activity);
        payment_back=(ImageView) findViewById(R.id.payment_back);
        payment_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PaymentInterfaceActivity.this,TheShoppingCartActivity.class);
				startActivity(intent);
				
			}
		});


    }

}
