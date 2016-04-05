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
import com.jiangkaiquan.activity.MyFriend;
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
 * 这个fragment是，我的板块中的展示fragment， 它加载的是我的板块布局
 * 
 * @创建时间 2016-03-09
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
	
	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 拿到本地application
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
			/* 设置头像 */
			case R.id.loginname_touxiang_intent_login:
				showDialog();

				break;
			/* 跳转设置 */
			case R.id.loginname_intent_setup:
				Intent intent_setup = new Intent(getActivity(),
						SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
			/* 跳转我的收藏 */
			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(
						getActivity(),
						MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;
			/* 跳转我的朋友 */
			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent(getActivity(),
						MyFriend.class);
				startActivity(intent);
				break;
			/* 跳转我的记录 */
			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(
						getActivity(), MyRecords.class);
				startActivity(intent_myrecords);
				break;
			/* 跳转购物车 */
			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(
						getActivity(),
						TheShopingCartActivityGG.class);
				startActivity(intent_shopingcart);
				break;
			/* 跳转个人信息 */
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
	 * 设置跳转到个人中心时用户的头像和昵称显示
	 */
	private void SetLoginState() {
		// 设置昵称
		if (app.user.getUserName() != null && app.user.getUserName() != "") {

			userName.setText(app.user.getUserName());

		} else if (app.user.getPhoneNum() != null
				&& app.user.getPhoneNum() != "") {

			userName.setText(app.user.getPhoneNum());
		}

		// 设置头像
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

	// 对话框
	public void showDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setTitle("头像设置");
		builder.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

			private File tempFile;

			@TargetApi(Build.VERSION_CODES.CUPCAKE)
			@SuppressLint("InlinedApi")
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				// 调用系统的拍照功能
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				// 指定调用相机拍照后照片的储存路径
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(tempFile));
				startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
			}
		});
		builder.setNegativeButton("相册", new DialogInterface.OnClickListener() {

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
		// crop为true是设置在开启的intent中设置显示的view可以剪裁
		intent.putExtra("crop", "true");
		// aspectX aspectY 是宽高的比例
		intent.putExtra("aspectX", 1);
		intent.putExtra("aspectY", 1);
		// outputX,outputY 是剪裁图片的宽高
		intent.putExtra("outputX", size);
		intent.putExtra("outputY", size);
		intent.putExtra("return-data", true);
		startActivityForResult(intent, PHOTO_REQUEST_CUT);
	}

	@SuppressLint("NewApi")

	// 将进行剪裁后的图片显示到UI界面上
	public void setPicToView(Intent picdata) {
		Bundle bundle = picdata.getExtras();
		if (bundle != null) {
			Bitmap photo = bundle.getParcelable("data");
			// Drawable drawable = new BitmapDrawable(photo);
			head_intent_login.setImageBitmap(photo);
		}
	}

	@SuppressLint("SimpleDateFormat")
	// 使用系统当前日期加以调整作为照片的名称
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
