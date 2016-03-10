package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

public class PersonalCenterLoginName extends Activity {
	ImageView intentMyRecords;
	ImageView intentMyFriend;
	ImageView intentMyCollection;
	ImageView intentShopCart;
	ImageView intentMyShare;
	ImageView intentVIP;
	RadioButton intentHomePage;
	RadioButton intentClassify;
	ImageView intentSetUp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_login_name);
		
		intentClassify = (RadioButton) findViewById(R.id.loginname_intent_Classify);
		intentClassify.setOnClickListener(onClickListener);
		intentHomePage = (RadioButton) findViewById(R.id.loginname_intent_homepage);
		intentHomePage.setOnClickListener(onClickListener);
		intentMyCollection = (ImageView) findViewById(R.id.loginname_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (ImageView) findViewById(R.id.loginname_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (ImageView) findViewById(R.id.loginname_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentMyShare = (ImageView) findViewById(R.id.loginname_intent_myshare);
		intentMyShare.setOnClickListener(onClickListener);
		intentShopCart = (ImageView) findViewById(R.id.loginname_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (ImageView) findViewById(R.id.loginname_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp=(ImageView)findViewById(R.id.loginname_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);
	}
	
	OnClickListener onClickListener=new OnClickListener(){

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.loginname_intent_Classify:
				Intent intent_classify = new Intent();
				startActivity(intent_classify);
				break;

			case R.id.loginname_intent_homepage:
				Intent intent_homepage = new Intent(PersonalCenterLoginName.this,HomePageActivity.class);
				startActivity(intent_homepage);
				break;

			case R.id.loginname_intent_setup:
				Intent intent_setup= new Intent(PersonalCenterLoginName.this,SetUpTheActivity.class);
				startActivity(intent_setup);
				break;

			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(PersonalCenterLoginName.this,MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent();
				startActivity(intent);
				break;

			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(PersonalCenterLoginName.this,MyRecords.class);
				startActivity(intent_myrecords);
				break;

			case R.id.loginname_intent_myshare:
				Intent intent_myshare = new Intent();
				startActivity(intent_myshare);
				break;

			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(PersonalCenterLoginName.this,TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			case R.id.loginname_intent_vip:
				Intent intent_vippage = new Intent();
				startActivity(intent_vippage);
				break;

			default:
				break;
			}
		}
		
		
	};

}
