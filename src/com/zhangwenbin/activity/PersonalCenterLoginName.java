package com.zhangwenbin.activity;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.jiangkaiquan.activity.MyFriend;
import com.zhangshun.activity.MyCollectionActivity;
import com.zhangshun.activity.PersonalInformationActivity;
import com.zhangshun.activity.SetUpTheActivity;
import com.zhangshun.activity.TheShoppingCartActivity;
import com.zhangshun.keep_in_good_health.R;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

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

	private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
	private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
	private static final int PHOTO_REQUEST_CUT = 3;// 结果
	// 创建一个以当前时间为名称的文件
	File tempFile = new File(Environment.getExternalStorageDirectory(), getPhotoFileName());

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.personal_center_login_name);

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

		head_intent_login = (ImageView) findViewById(R.id.loginname_touxiang_intent_login);
		head_intent_login.setOnClickListener(onClickListener);

	}

	OnCheckedChangeListener listener = new OnCheckedChangeListener() {

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			case R.id.home_page:
				// Intent intent_homepage = new Intent();
				// intent_homepage.setClass(PersonalCenterLoginName.this,
				// HomePageActivity.class);
				// startActivity(intent_homepage);
				break;
			case R.id.classify:
				// Intent intent_class = new Intent();
				// intent_class.setClass(PersonalCenterLoginName.this,
				// CommonDiseasesListForDetailsAcitivty.class);
				// startActivity(intent_class);
				break;
			}
		}

	};

	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			switch (arg0.getId()) {
			/* 设置头像 */
			case R.id.loginname_touxiang_intent_login:
				showDialog();
				break;
			/* 跳转设置 */
			case R.id.loginname_intent_setup:
				Intent intent_setup = new Intent(PersonalCenterLoginName.this, SetUpTheActivity.class);
				startActivity(intent_setup);
				break;
			/* 跳转我的收藏 */
			case R.id.loginname_intent_mycollection:
				Intent intent_mycollection = new Intent(PersonalCenterLoginName.this, MyCollectionActivity.class);
				startActivity(intent_mycollection);
				break;
			/* 跳转我的朋友 */
			case R.id.loginname_intent_myfriend:
				Intent intent = new Intent(PersonalCenterLoginName.this, MyFriend.class);
				startActivity(intent);
				break;
			/* 跳转我的记录 */
			case R.id.loginname_intent_myrecords:
				Intent intent_myrecords = new Intent(PersonalCenterLoginName.this, MyRecords.class);
				startActivity(intent_myrecords);
				break;
			/* 跳转购物车 */
			case R.id.loginname_intent_shoppingcart:
				Intent intent_shopingcart = new Intent(PersonalCenterLoginName.this, TheShoppingCartActivity.class);
				startActivity(intent_shopingcart);
				break;
			/* 跳转个人信息 */
			case R.id.loginname_intent_vip:
				Intent intent_vippage = new Intent(PersonalCenterLoginName.this, PersonalInformationActivity.class);
				startActivity(intent_vippage);
				break;

			default:
				break;
			}

		}
	};

	// 对话框
	public void showDialog() {

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("头像设置");
		builder.setPositiveButton("拍照", new DialogInterface.OnClickListener() {

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
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
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
	@SuppressWarnings("deprecation")
	// 将进行剪裁后的图片显示到UI界面上
	public void setPicToView(Intent picdata) {
		Bundle bundle = picdata.getExtras();
		if (bundle != null) {
			Bitmap photo = bundle.getParcelable("data");
			//Drawable drawable = new BitmapDrawable(photo);
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

}
