package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.jiangkaiquan.activity.MyFriend;
import com.ruanjiawei.activity.LoginActivity;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.PersonalInformationActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

public class PersonalCenterLoginName extends Activity {
	LinearLayout intentMyRecords;
	LinearLayout intentMyFriend;
	LinearLayout intentMyCollection;
	LinearLayout intentShopCart;
	LinearLayout intentVIP;
	RadioButton intentHomePage;
	RadioButton intentClassify;
	ImageView intentSetUp;
	Button my_friend_new_tx, my_friend_issue_group_tx;
	ImageView head_intent_login;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_login_name);
		intentHomePage = (RadioButton) findViewById(R.id.home_page);
		intentHomePage.setOnCheckedChangeListener(listener);
		intentClassify = (RadioButton) findViewById(R.id.classify);
		intentClassify.setOnCheckedChangeListener(listener);

		intentMyCollection = (LinearLayout) findViewById(R.id.loginname_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (LinearLayout) findViewById(R.id.loginname_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (LinearLayout) findViewById(R.id.loginname_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentShopCart = (LinearLayout) findViewById(R.id.loginname_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (LinearLayout) findViewById(R.id.loginname_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) findViewById(R.id.loginname_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);
		head_intent_login = (ImageView) findViewById(R.id.loginname_touxiang_intent_);
		head_intent_login.setOnClickListener(onClickListener);

	}

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.home_page:
				Intent intent_homepage = new Intent();
				intent_homepage.setClass(PersonalCenterLoginName.this, HomePageActivity.class);
				startActivity(intent_homepage);
				break;
			case R.id.classify:
				Intent intent_class = new Intent();
				intent_class.setClass(PersonalCenterLoginName.this, CommonDiseasesListForDetailsAcitivty.class);
				startActivity(intent_class);
				break;
			}
		}

	};

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.loginname_touxiang_intent_:
				Intent intent_login = new Intent(PersonalCenterLoginName.this, LoginActivity.class);
				startActivity(intent_login);
				break;

			case R.id.loginname_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterLoginName.this, SetUpTheActivity.class);
				startActivity(intent_setup);
				break;

			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(PersonalCenterLoginName.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent(PersonalCenterLoginName.this, MyFriend.class);
				startActivity(intent);
				break;

			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(PersonalCenterLoginName.this, MyRecords.class);
				startActivity(intent_myrecords);
				break;
			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(PersonalCenterLoginName.this, TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			case R.id.loginname_intent_vip:
				Intent intent_vippage = new Intent(PersonalCenterLoginName.this, PersonalInformationActivity.class);
				startActivity(intent_vippage);
				break;

			default:
				break;
			}

		}
	};

}
