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
import android.widget.LinearLayout;
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
	LinearLayout intentMyRecords;
	LinearLayout intentMyFriend;
	LinearLayout intentMyCollection;
	LinearLayout intentShopCart;
	LinearLayout intentMyShare;
	LinearLayout intentVIP;
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
		intentClassify = (RadioButton) findViewById(R.id.notlogin_intent_Classify);
		intentClassify.setOnCheckedChangeListener(listener);
		intentHomePage = (RadioButton) findViewById(R.id.notlogin_intent_homepage);
		intentHomePage.setOnCheckedChangeListener(listener);
		
		
		intentMyCollection = (LinearLayout) findViewById(R.id.notlogin_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (LinearLayout) findViewById(R.id.notlogin_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (LinearLayout) findViewById(R.id.notlogin_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentShopCart = (LinearLayout) findViewById(R.id.notlogin_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (LinearLayout) findViewById(R.id.notlogin_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) findViewById(R.id.notlogin_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);
		intentLogin=(TextView)findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setOnClickListener(onClickListener);

	}
	
	OnCheckedChangeListener listener=new OnCheckedChangeListener(){

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
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
			}
		}
		
		
	};

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			/*跳转到已登录*/
			case R.id.personal_not_login_intent_login:
				Intent intent_login = new Intent(
						PersonalCenterNotLogin.this, LoginActivity.class);
				startActivity(intent_login);
				break;
				/*跳转到我的收藏*/
			case R.id.notlogin_intent_mycollection:
				Intent intent_mycollection = new Intent(
						PersonalCenterNotLogin.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;
				/*跳转到我的好友*/
			case R.id.notlogin_intent_myfriend:
				Intent intent = new Intent(PersonalCenterNotLogin.this,MyFriend.class);
				startActivity(intent);
				break;
				/*跳转到我的记录*/
			case R.id.notlogin_intent_myrecords:
				Intent intent_myrecords = new Intent(
						PersonalCenterNotLogin.this, MyRecords.class);
				startActivity(intent_myrecords);
				break;
				/*跳转到购物车*/
			case R.id.notlogin_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						PersonalCenterNotLogin.this,
						TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
				/*跳转到设置*/
			case R.id.notlogin_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterNotLogin.this,
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
				/*跳转到个人信息*/
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
