package com.zhangrong.fragment;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import com.jiangkaiquan.activity.MyFriend1;
import com.jiangkaiquan.aplication.MyApplaication;
import com.ruanjiawei.activity.LoginActivity;
import com.zhangrong.activity.TheShopingCartActivityGG;
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
 * 杩欎釜fragment鏄紝鎴戠殑鏉垮潡涓殑灞曠ずfragment锛� 瀹冨姞杞界殑鏄垜鐨勬澘鍧楀竷灞�
 * 
 * @鍒涘缓鏃堕棿 2016-03-09
 */
public class MyFragment extends Fragment {
	
	MyApplaication app;
	LinearLayout intentMyRecords;
	LinearLayout intentMyFriend;
	LinearLayout intentMyCollection;
	LinearLayout intentShopCart;
	LinearLayout intentVIP;
	ImageView intentSetUp;
	ImageView userImg;
	Button my_friend_new_tx, my_friend_issue_group_tx;
	TextView intentLogin;
	TextView userName;
	private ImageView head_intent_login;
	
	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 鎷嶇収
	private static final int PHOTO_REQUEST_GALLERY = 2;// 浠庣浉鍐屼腑閫夋嫨
	private static final int PHOTO_REQUEST_CUT = 3;// 缁撴灉

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 鎷垮埌鏈湴application
		app = (MyApplaication) getActivity().getApplication();
		View view = inflater.inflate(R.layout.personal_center_login_name,
				container, false);

		intentMyCollection = (LinearLayout) view.findViewById(R.id.loginname_intent_mycollection);
		intentMyCollection.setOnClickListener(onClickListener);
		intentMyFriend = (LinearLayout) view.findViewById(R.id.loginname_intent_myfriend);
		intentMyFriend.setOnClickListener(onClickListener);
		intentMyRecords = (LinearLayout) view.findViewById(R.id.loginname_intent_myrecords);
		intentMyRecords.setOnClickListener(onClickListener);
		intentShopCart = (LinearLayout) view.findViewById(R.id.loginname_intent_shoppingcart);
		intentShopCart.setOnClickListener(onClickListener);
		intentVIP = (LinearLayout) view.findViewById(R.id.loginname_intent_vip);
		intentVIP.setOnClickListener(onClickListener);
		intentSetUp = (ImageView) view.findViewById(R.id.loginname_intent_setup);
		intentSetUp.setOnClickListener(onClickListener);

		userName = (TextView) view.findViewById(R.id.personal_not_login_intent_login);
		userName.setOnClickListener(onClickListener);
		head_intent_login = (ImageView) view.findViewById(R.id.loginname_touxiang_intent_login);
		head_intent_login.setOnClickListener(onClickListener);
		
		SetLoginState();
		return view;
	}

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			
			case R.id.personal_not_login_intent_login:
				Intent intent_login = new Intent();
				intent_login.setClass(getActivity(), LoginActivity.class);
				startActivity(intent_login);
				break;
			/* 璁剧疆澶村儚 */
			case R.id.loginname_touxiang_intent_login:
				showDialog();

				break;
			/* 璺宠浆璁剧疆 */
			case R.id.loginname_intent_setup:
				Intent intent_setup = new Intent(getActivity(),
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
			/* 璺宠浆鎴戠殑鏀惰棌 */
			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(
						getActivity(),
						MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;
			/* 璺宠浆鎴戠殑鏈嬪弸 */
			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent(getActivity(),
						MyFriend1.class);
				startActivity(intent);
				break;
			/* 璺宠浆鎴戠殑璁板綍 */
			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(
						getActivity(), MyRecords.class);
				startActivity(intent_myrecords);
				break;
			/* 璺宠浆璐墿杞� */
			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						getActivity(),
						TheShopingCartActivityGG.class);
				startActivity(intent_shopingcart);
				break;
			/* 璺宠浆涓汉淇℃伅 */
			case R.id.loginname_intent_vip:
				Intent intent_vippage = new Intent(
						getActivity(),
						PersonalInformationActivity.class);
				startActivity(intent_vippage);
				break;
			}

		}
	};
	private File tempFile;

	/**
	 * 璁剧疆璺宠浆鍒颁釜浜轰腑蹇冩椂鐢ㄦ埛鐨勫ご鍍忓拰鏄电О鏄剧ず
	 */
	private void SetLoginState() {
		// 璁剧疆鏄电О
		if (app.user.getUserName() != null && app.user.getUserName() != "") {

			userName.setText(app.user.getUserName());

		} else if (app.user.getPhoneNum() != null
				&& app.user.getPhoneNum() != "") {

			userName.setText(app.user.getPhoneNum());
		}

		// 璁剧疆澶村儚
		if (app.user.getUserImg() != null) {
			head_intent_login.setImageBitmap(app.user.getUserImg());
		}
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		SetLoginState();
		super.onResume();
	}

	// 瀵硅瘽妗�
	public void showDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("澶村儚璁剧疆");
		builder.setPositiveButton("鎷嶇収", new DialogInterface.OnClickListener() {

			private File tempFile;

			@TargetApi(Build.VERSION_CODES.CUPCAKE)
			@SuppressLint("InlinedApi")
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				// 璋冪敤绯荤粺鐨勬媿鐓у姛鑳�
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// 鎸囧畾璋冪敤鐩告満鎷嶇収鍚庣収鐗囩殑鍌ㄥ瓨璺緞
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
				startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
			}
		});
		builder.setNegativeButton("鐩稿唽", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO Auto-generated method stub
				arg0.dismiss();
				Intent intent = new Intent(Intent.ACTION_PICK, null);
				intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
				startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
			}
		}).show();

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case PHOTO_REQUEST_TAKEPHOTO:
			startPhotoZoom(Uri.fromFile(tempFile), 80);
			break;
		case PHOTO_REQUEST_GALLERY:
			if (data != null)
				startPhotoZoom(data.getData(), 80);
			break;
		case PHOTO_REQUEST_CUT:
			if (data != null)
				setPicToView(data);
			break;
		default:
			break;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	public void startPhotoZoom(Uri uri, int size) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		// crop涓簍rue鏄缃湪寮�鍚殑intent涓缃樉绀虹殑view鍙互鍓
		intent.putExtra("crop", "true");
		// aspectX aspectY 鏄楂樼殑姣斾緥
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX,outputY 鏄壀瑁佸浘鐗囩殑瀹介珮
		intent.putExtra("outputX", size);
		intent.putExtra("outputY", size);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	@SuppressLint("NewApi")

	// 灏嗚繘琛屽壀瑁佸悗鐨勫浘鐗囨樉绀哄埌UI鐣岄潰涓�
	public void setPicToView(Intent picdata) {
		Bundle bundle = picdata.getExtras();
		if (bundle != null) {
			Bitmap photo = bundle.getParcelable("data");
			// Drawable drawable = new BitmapDrawable(photo);
			head_intent_login.setImageBitmap(photo);
		}
	}

	@SuppressLint("SimpleDateFormat")
	// 浣跨敤绯荤粺褰撳墠鏃ユ湡鍔犱互璋冩暣浣滀负鐓х墖鐨勫悕绉�
	public String getPhotoFileName() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
		String datatime = format.format(date) + ".jpg";
		return datatime;
	}

	public void sendResponsePost() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				BasicHttpParams basicHttpParams = new BasicHttpParams();
				HttpConnectionParams.setConnectionTimeout(basicHttpParams, 8000);
				HttpConnectionParams.setSoTimeout(basicHttpParams, 8000);

				HttpClient httpClient = new DefaultHttpClient(basicHttpParams);
				HttpPost httpPost = new HttpPost();
				List<NameValuePair> pairs = new ArrayList<NameValuePair>();
				pairs.add(new BasicNameValuePair("", ""));
				try {
					UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
					httpPost.setEntity(entity);
					httpClient.execute(httpPost);
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}
