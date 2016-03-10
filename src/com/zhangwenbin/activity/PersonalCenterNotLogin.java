package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.ruanjiawei.activity.LoginActivity;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

public class PersonalCenterNotLogin extends Activity {
	ImageView intentMyRecords;
	ImageView intentMyFriend;
	ImageView intentMyCollection;
	ImageView intentShopCart;
	ImageView intentMyShare;
	ImageView intentVIP;
	RadioButton intentHomePage;
	RadioButton intentClassify;
	ImageView intentLoginName;
	ImageView intentSetUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_not_login);
		intentClassify = (RadioButton) findViewById(R.id.notlogin_intent_Classify);
		intentClassify.setOnClickListener(onClickListener);
		intentHomePage = (RadioButton) findViewById(R.id.notlogin_intent_homepage);
		intentHomePage.setOnClickListener(onClickListener);
		intentMyCollection = (ImageView) findViewById(R.id.notlogin_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (ImageView) findViewById(R.id.notlogin_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (ImageView) findViewById(R.id.notlogin_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentMyShare = (ImageView) findViewById(R.id.notlogin_intent_myshare);
		intentMyShare.setOnClickListener(onClickListener);
		intentShopCart = (ImageView) findViewById(R.id.notlogin_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (ImageView) findViewById(R.id.notlogin_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentLoginName = (ImageView) findViewById(R.id.notlogin_intent_loginname);
		intentLoginName.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) findViewById(R.id.notlogin_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);

	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.notlogin_intent_Classify:
				Intent intent_classify = new Intent(
						PersonalCenterNotLogin.this,
						CommonDiseasesListForDetailsAcitivty.class);
				startActivity(intent_classify);
				break;

			case R.id.notlogin_intent_homepage:
				Intent intent_homepage = new Intent(
						PersonalCenterNotLogin.this, HomePageActivity.class);
				startActivity(intent_homepage);
				break;

			case R.id.notlogin_intent_loginname:
				Intent intent_loginname = new Intent(
						PersonalCenterNotLogin.this, LoginActivity.class);
				startActivity(intent_loginname);
				break;

			case R.id.notlogin_intent_mycollection:
				Intent intent_mycollection = new Intent(
						PersonalCenterNotLogin.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.notlogin_intent_myfriend:
				Intent intent = new Intent();
				startActivity(intent);
				break;

			case R.id.notlogin_intent_myrecords:
				Intent intent_myrecords = new Intent(
						PersonalCenterNotLogin.this, MyRecords.class);
				startActivity(intent_myrecords);
				break;

			case R.id.notlogin_intent_myshare:
				Intent intent_myshare = new Intent(PersonalCenterNotLogin.this,
						LoginActivity.class);
				startActivity(intent_myshare);
				break;

			case R.id.notlogin_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						PersonalCenterNotLogin.this,
						TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			case R.id.notlogin_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterNotLogin.this,
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
			case R.id.notlogin_intent_vip:
				Intent intent_vip = new Intent(PersonalCenterNotLogin.this,
						LoginActivity.class);
				startActivity(intent_vip);
				break;

			default:
				break;
			}
		}

	};

}
