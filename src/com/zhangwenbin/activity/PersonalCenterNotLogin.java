package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.jiangkaiquan.activity.MyFriend;
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
	TextView intentLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_not_login);

		intentMyCollection = (ImageView) findViewById(R.id.notlogin_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (ImageView) findViewById(R.id.notlogin_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (ImageView) findViewById(R.id.notlogin_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentShopCart = (ImageView) findViewById(R.id.notlogin_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (ImageView) findViewById(R.id.notlogin_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) findViewById(R.id.notlogin_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);
		intentLogin=(TextView)findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setOnClickListener(onClickListener);

	}
	

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.personal_not_login_intent_login:
				Intent intent_login = new Intent(
						PersonalCenterNotLogin.this, LoginActivity.class);
				startActivity(intent_login);
				break;

			case R.id.notlogin_intent_mycollection:
				Intent intent_mycollection = new Intent(
						PersonalCenterNotLogin.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.notlogin_intent_myfriend:
				Intent intent = new Intent(PersonalCenterNotLogin.this,MyFriend.class);
				startActivity(intent);
				break;

			case R.id.notlogin_intent_myrecords:
				Intent intent_myrecords = new Intent(
						PersonalCenterNotLogin.this, MyRecords.class);
				startActivity(intent_myrecords);
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
