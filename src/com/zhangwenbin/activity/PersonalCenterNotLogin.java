package com.zhangwenbin.activity;

import com.jiangkaiquan.activity.MyFriend1;
import com.ruanjiawei.activity.LoginActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jiangkaiquan.activity.MyFriend1;
import com.ruanjiawei.activity.LoginActivity;
import com.ruanjiawei.demo.SaveToken;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.PersonalInformationActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

/*我的（未登錄）頁面*/

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

	//TextView intentLogin;
	/*String address = "http://192.168.11.247/index.php/home/api/myrecords";
	String response = HttpUtil.sendHttpRequest(address, new HttpCallBackInterface() {

		public void onFinish(String response) {
			// TODO Auto-generated method stub
			// 在这里根据返回内容执行具体的逻辑，处理响应数据
		}
		public void onError(Exception e) {
			// TODO Auto-generated method stub
			// 在这里对异常情况进行处理
		}
	});

	@SuppressLint("NewApi")*/

	TextView intentLogin, user_name;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_not_login);
		// CheckIsLogin();

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
		intentLogin = (TextView) findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setOnClickListener(onClickListener);

		
		/*MyRecordsFragmentReceive receive=new MyRecordsFragmentReceive();
		receive.getJsonObject(response);*/

		user_name = (TextView) findViewById(R.id.user_name);


	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
<<<<<<< HEAD
			/* 跳转到登录 */
=======

			/*跳转到登录*/

			/* 跳转到已登录 */

>>>>>>> develop
			case R.id.personal_not_login_intent_login:
				Intent intent_login = new Intent(PersonalCenterNotLogin.this,
						LoginActivity.class);
				startActivity(intent_login);
				break;
			/* 跳转到我的收藏 */
			case R.id.notlogin_intent_mycollection:
				Intent intent_mycollection = new Intent(
						PersonalCenterNotLogin.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;
			/* 跳转到我的好友 */
			case R.id.notlogin_intent_myfriend:
				Intent intent = new Intent(PersonalCenterNotLogin.this,
						MyFriend1.class);
				startActivity(intent);
				break;
			/* 跳转到我的记录 */
			case R.id.notlogin_intent_myrecords:
				Intent intent_myrecords = new Intent(
						PersonalCenterNotLogin.this, MyRecords.class);
				startActivity(intent_myrecords);
				
				break;
			/* 跳转到购物车 */
			case R.id.notlogin_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						PersonalCenterNotLogin.this,
						TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			/* 跳转到设置 */
			case R.id.notlogin_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterNotLogin.this,
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
			/* 跳转到登录 */
			case R.id.notlogin_intent_vip:
				Intent login = new Intent(PersonalCenterNotLogin.this,
						LoginActivity.class);
				startActivity(login);
				Toast.makeText(getApplicationContext(), "请先登录",
						Toast.LENGTH_LONG).show();
				break;

			default:
				break;
			}
		}

	};

	private void CheckLogin() {
		// 获取本地的SaveToken存储的token值
		String token = SaveToken.getData(getApplicationContext());
		if (token == null || token.equals(" ")) {
			Intent intent_vip = new Intent(PersonalCenterNotLogin.this,
					LoginActivity.class);
			startActivity(intent_vip);
		} else {
			Intent intent_vip = new Intent(PersonalCenterNotLogin.this,
					PersonalInformationActivity.class);
			startActivity(intent_vip);
		}
	}

	/**
	 * 判断是否处于登录状态
	 */

	private void CheckIsLogin() {

		// 获取本地的SaveToken存储的token值
		String token = SaveToken.getData(getApplicationContext());
		Log.i("CheckIsLogin", "token=" + token);
		if (token == null && token.equals("")) {// 判断获取的token值是否为空
			Log.i("CheckIsLogin", "当前没有处于登录状态");
			judgeUnLongin(); // 没有登录的方法
		} else {
			// 不为空，则显示个人信息
			judgeLongin(); // 登录成功的方法
		}
	}

	// 登录
	private void judgeLongin() {
		// TODO Auto-generated method stub
		user_name = (TextView) findViewById(R.id.user_name);
		user_name.setVisibility(View.INVISIBLE);
		intentLogin = (TextView) findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setVisibility(View.GONE);

	}

	// 未登录
	private void judgeUnLongin() {
		// TODO Auto-generated method stub
		user_name = (TextView) findViewById(R.id.user_name);
		user_name.setVisibility(View.GONE);
		intentLogin = (TextView) findViewById(R.id.personal_not_login_intent_login);
		intentLogin.setVisibility(View.INVISIBLE);
	}

}
