package com.zhangwenbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.jiangkaiquan.activity.MyFriend;
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

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_login_name);

		// intentClassify = (RadioButton)
		// findViewById(R.id.loginname_intent_Classify);
		// intentClassify.setOnClickListener(onClickListener);
		// intentHomePage = (RadioButton)
		// findViewById(R.id.loginname_intent_homepage);
		// intentHomePage.setOnClickListener(onClickListener);
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

		my_friend_new_tx = (Button) findViewById(R.id.my_friend_new_tx);
		my_friend_issue_group_tx = (Button) findViewById(R.id.my_friend_issue_group_tx);

		my_friend_new_tx.setOnClickListener(listener);
		my_friend_issue_group_tx.setOnClickListener(listener);

	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.my_friend_new_tx:
				Intent intent = new Intent();
				intent.setClass(PersonalCenterLoginName.this,
						HomePageActivity.class);
				startActivity(intent);
				break;
			case R.id.my_friend_issue_group_tx:
				break;
			default:
				break;
			}
		}

	};

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			// case R.id.loginname_intent_Classify:
			// Intent intent_classify = new Intent(
			// PersonalCenterLoginName.this,
			// CommonDiseasesListForDetailsAcitivty.class);
			// startActivity(intent_classify);
			// break;

			// case R.id.loginname_intent_homepage:
			// Intent intent_homepage = new Intent(
			// PersonalCenterLoginName.this, HomePageActivity.class);
			// startActivity(intent_homepage);
			// break;

			case R.id.loginname_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterLoginName.this,
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;

			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(
						PersonalCenterLoginName.this,
						MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent(PersonalCenterLoginName.this,
						MyFriend.class);
				startActivity(intent);
				break;

			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(
						PersonalCenterLoginName.this, MyRecords.class);
				startActivity(intent_myrecords);
				break;
			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						PersonalCenterLoginName.this,
						TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			case R.id.loginname_intent_vip:
				Intent intent_vippage = new Intent(
						PersonalCenterLoginName.this,
						PersonalInformationActivity.class);
				startActivity(intent_vippage);
				break;

			default:
				break;
			}
		}

	};

}
