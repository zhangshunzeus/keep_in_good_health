package com.zhangrong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.jiangkaiquan.activity.MyFriend1;
import com.ruanjiawei.activity.LoginActivity;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.PersonalInformationActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.MyRecords;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import com.zhangwenbin.activity.PersonalCenterNotLogin;

/**
 * 这个fragment是，我的板块中的展示fragment， 它加载的是我的板块布局
 * 
 * @创建时间 2016-03-09
 */
public class MyFragment extends Fragment {
	LinearLayout intentMyRecords;
	LinearLayout intentMyFriend;
	LinearLayout intentMyCollection;
	LinearLayout intentShopCart;
	LinearLayout intentVIP;
	ImageView intentSetUp;
	Button my_friend_new_tx, my_friend_issue_group_tx;
	TextView intentLogin;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.personal_center_not_login, container, false);

		intentMyCollection = (LinearLayout) view.findViewById(R.id.notlogin_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (LinearLayout) view.findViewById(R.id.notlogin_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (LinearLayout) view.findViewById(R.id.notlogin_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentShopCart = (LinearLayout) view.findViewById(R.id.notlogin_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (LinearLayout) view.findViewById(R.id.notlogin_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) view.findViewById(R.id.notlogin_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);
		intentLogin = (TextView) view.findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setOnClickListener(onClickListener);

		return view;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {

			case R.id.notlogin_intent_setup:
				Intent intent_setup = new Intent(getActivity(), SetUpTheActivity.class);
				startActivity(intent_setup);
				break;

			case R.id.notlogin_intent_mycollection:
				Intent intent_mycollection = new Intent(getActivity(), MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;

			case R.id.notlogin_intent_myfriend:
				Intent intent = new Intent(getActivity(), MyFriend1.class);
				startActivity(intent);
				break;

			case R.id.notlogin_intent_myrecords:
				Intent intent_myrecords = new Intent(getActivity(), MyRecords.class);
				startActivity(intent_myrecords);
				break;
			case R.id.notlogin_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(getActivity(), TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			case R.id.notlogin_intent_vip:
				Intent intent_vippage = new Intent(getActivity(), PersonalInformationActivity.class);
				startActivity(intent_vippage);
				break;
			case R.id.personal_not_login_intent_login:
				Intent intent_login = new Intent(getActivity(), LoginActivity.class);
				startActivity(intent_login);
				break;

			default:
				break;
			}

		}
	};

}