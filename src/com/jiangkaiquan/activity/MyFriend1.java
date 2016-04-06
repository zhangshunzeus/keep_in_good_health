package com.jiangkaiquan.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiangkaiquan.activity.adapter.MyFriend1Ad;
import com.jiangkaiquan.activity.adapter.NetUrl;
import com.zhangshun.keep_in_good_health.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by jkqme on 2016/3/14.
 * <p/>
 * MyFriend 的更新 先在activity里获取好友列表，在adapter里或取头像列表 //// \n添加好友的跳转resultCode=1;
 */
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class MyFriend1 extends Activity {

	WifiConfiguration configuration;
	private TextView view1;
	private TextView view2;
	private Intent intent;
	private ImageView back;
	private ImageView add;
	private TextView friend;
	private TextView social;
	private PopupWindow pwind;

	private ListView listview;
	private ListView listView2;
	private MyFriend1Ad adpter;
	private MyFriend1Ad adpter2;
	private ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
	private ArrayList<HashMap<String, String>> list2 = new ArrayList<HashMap<String, String>>();

	private RelativeLayout layout;
	private AlertDialog dialog;
	private AlertDialog.Builder builder;
	WindowManager.LayoutParams lp;

	String ip = NetUrl.ip1;
	// String ips="http:";
	String addDate = "addDate";
	String addDates = "addDstes";
	String addAll = "addAll";
	String addAlls = "addAlls";
	String chekAll = "chekAll";
	String chekAlls = "chekAlls";

	// 初始化list1;
	@SuppressLint("NewApi")
	AsyncTask<Context, String, Context> friendAsy = new AsyncTask<Context, String, Context>() {

		@Override
		protected Context doInBackground(Context... params) {
			// TODO Auto-generated method stub
			// 获取网络json
			Context str = params[0];
			String friendDate = getDateByHttpConnection(ip + NetUrl.friend
					+ chekAll);
			// Log.i("result==>Asy", friendDate);
			Log.i("friendAsy", friendDate);
			if (friendDate.equals("warn"))
				return null;
			DealJson dJson = new DealJson(friendDate, true);

			return str;
		}

		protected void onPostExecute(Context result) {
			// 判断是否需要重置list
			if (result != null) {
				if (adpter != null) {
					adpter.notiChange(list1);
				} else {
					adpter = new MyFriend1Ad(list1, result, false);
					listview.setAdapter(adpter);
				}
			}
		}
	};
	// 初始化list2;
	@SuppressLint("NewApi")
	AsyncTask<Context, String, Context> socilAsy = new AsyncTask<Context, String, Context>() {

		@Override
		protected Context doInBackground(Context... params) {
			// TODO Auto-generated method stub
			// 获取网络json
			Context str = params[0];
			String friendDate = getDateByHttpConnection(ip + NetUrl.friend
					+ chekAlls);
			// Log.i("result==>Asy", friendDate);
			Log.i("SocialAsy", friendDate);
			if (friendDate.equals("warn"))
				return null;
			DealJson dJson = new DealJson(friendDate, false);

			return str;
		}

		protected void onPostExecute(Context result) {
			if (result != null) {
				if (adpter2 != null) {
					adpter2.notiChange(list2);
				} else {
					adpter2 = new MyFriend1Ad(list2, result, false);
					listView2.setAdapter(adpter2);
				}

			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.jiang_my_friend_1);
		back = (ImageView) findViewById(R.id.myfriend1_back_img);
		add = (ImageView) findViewById(R.id.myfriend1_add_img);
		friend = (TextView) findViewById(R.id.myfriend1_friend_tx);
		social = (TextView) findViewById(R.id.myfriend1_social_tx);
		layout = (RelativeLayout) findViewById(R.id.friend1_rl);

		view1 = (TextView) findViewById(R.id.myfriend_line1_v);
		view2 = (TextView) findViewById(R.id.myfriend_line2_v);
		// listview 准备

		listview = (ListView) findViewById(R.id.myfrend1_lv);
		listView2 = (ListView) findViewById(R.id.myfrend1_1v2);
		friendAsy.execute(this);
		socilAsy.execute(this);
		back.setOnClickListener(listener);
		add.setOnClickListener(listener);
		friend.setOnClickListener(listener);

		social.setOnClickListener(listener);

	}

	private View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			// dissmis popuwind
			if (pwind != null && pwind.isShowing()) {
				pwind.dismiss();
			}
			switch (view.getId()) {
			case R.id.myfriend1_back_img:
				finish();
				break;
			case R.id.myfriend1_add_img:
				showDiolog(true);
				break;
			case R.id.myfriend1_friend_tx:
				friend.setTextColor(getResources().getColor(
						R.color.friendbt_change));
				social.setTextColor(getResources().getColor(
						R.color.frendbt_no_change));
				listview.setVisibility(View.VISIBLE);

				listView2.setVisibility(View.GONE);
				view1.setVisibility(View.VISIBLE);
				view2.setVisibility(View.INVISIBLE);
				break;
			case R.id.myfriend1_social_tx:
				social.setTextColor(getResources().getColor(
						R.color.friendbt_change));
				friend.setTextColor(getResources().getColor(
						R.color.frendbt_no_change));
				view2.setVisibility(View.VISIBLE);
				view1.setVisibility(View.INVISIBLE);

				listView2.setVisibility(View.VISIBLE);
				listview.setVisibility(View.GONE);
				break;
			case R.id.friend_swap_tx:

				intent = new Intent(MyFriend1.this, DecoderActivity.class);

				startActivity(intent);

				break;
			case R.id.friend_add_tx:
				intent = new Intent(MyFriend1.this, AddFriendOrSocial.class);
				intent.putExtra("isFriend", true);
				startActivityForResult(intent, 1);
				break;
			case R.id.friend_creat_social_tx:
				intent = new Intent(MyFriend1.this, AddFriendOrSocial.class);
				intent.putExtra("isFriend", false);
				startActivityForResult(intent, 1);
				break;
			}
		}
	};

	private void displayPopuwind() {
		if (pwind == null) {
			int id[] = { R.id.friend_swap_tx, R.id.friend_add_tx,
					R.id.friend_creat_social_tx };
			View view = LayoutInflater.from(this).inflate(
					R.layout.jiang_popwind_my_friend, null);
			TextView text;
			for (int i = 0; i < id.length; i++) {
				text = (TextView) view.findViewById(id[i]);
				text.setSelected(true);
				text.setOnClickListener(listener);
			}
			// 显示popuwind
			pwind = new PopupWindow(view);

			// 加pupowind页面
			// pwind.setContentView(view);
			pwind.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
			pwind.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
		}
		pwind.showAsDropDown(layout);

		pwind.setOnDismissListener(ondismis);
	}

	// 不显示接口
	private PopupWindow.OnDismissListener ondismis = new PopupWindow.OnDismissListener() {
		@Override
		public void onDismiss() {

		}
	};

	// 设置diolog
	private void showDiolog(boolean toshow) {
		if (dialog == null) {
			// dialog 弹出窗试图
			int id[] = { R.id.friend_swap_tx, R.id.friend_add_tx,
					R.id.friend_creat_social_tx };
			View view = LayoutInflater.from(this).inflate(
					R.layout.jiang_popwind_my_friend, null);
			TextView text;
			for (int i = 0; i < id.length; i++) {
				text = (TextView) view.findViewById(id[i]);
				text.setSelected(true);
				text.setOnClickListener(listener);
			}
			// dialog位置设置
			int w = layout.getWidth();
			int h = layout.getHeight();
			builder = new AlertDialog.Builder(this);
			builder.setView(view);
			dialog = builder.create();
			// dialog.setContentView(R.layout.jiang_popwind_my_friend);

			// 获得当前窗体
			Window window = dialog.getWindow();

			// 重新设置
			lp = window.getAttributes();
			window.setGravity(Gravity.RIGHT | Gravity.TOP);
			lp.x = 0; // 新位置X坐标
			lp.y = 50; // 新位置Y坐标
			lp.width = 100; // 宽度
			lp.height = 200; // 高度
			lp.alpha = 0.9f; // 透明度

			// dialog.onWindowAttributesChanged(lp);
			// (当Window的Attributes改变时系统会调用此函数)
			window.setAttributes(lp);
		}
		// builder.notify();

		if (toshow) {
			dialog.show();
		} else {
			dialog.hide();
		}

	}

	// 我的好友数据
	private void getFriendDate() {
		HashMap<String, Object> map;
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

		int imgId[] = { R.drawable.friend1, R.drawable.friend2,
				R.drawable.friend3, R.drawable.friend4, R.drawable.friend5,
				R.drawable.friend6, R.drawable.friend7, R.drawable.friend8 };
		String text[] = { "重我最帅", "fdsa", "我来拯救地球", "美女", "较比手好用", "哈", "天王",
				"着了" };
		for (int i = 0; i < imgId.length; i++) {
			map = new HashMap<String, Object>();
			map.put("img", imgId[i]);
			map.put("text", text[i]);
			list.add(map);
		}

	}

	// 我的群数据
	private void getSocialDate() {
		HashMap<String, String> map;
		list2 = new ArrayList<HashMap<String, String>>();
		int imgId[] = { R.drawable.social1, R.drawable.social2,
				R.drawable.social3, R.drawable.social6 };
		String text[] = { "健康", "美丽", "运动", "90后" };
		for (int i = 0; i < imgId.length; i++) {
			map = new HashMap<String, String>();
			// map.put("img", imgId[i]);
			map.put("text", text[i]);
			list2.add(map);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		showDiolog(false);
		super.onResume();
	}

	/**
	 * 网络访问的类方法
	 * 
	 * @author jkqme 获取网络数据 耗时
	 */
	public String getDateByHttpConnection(String urls) {
		StringBuilder sBuilder = new StringBuilder();
		HttpURLConnection connection;

		String url = null;

		url = urls;

		try {
			URL mUrl = new URL(url);
			connection = (HttpURLConnection) mUrl.openConnection();

			connection.setReadTimeout(5000);
			connection.setConnectTimeout(5000);
			connection.setRequestMethod("GET");
			try {
				connection.connect();
			} catch (ConnectException e) {
				Toast.makeText(this, "网络故障", 2000);
				return null;
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			if (connection.getResponseCode() == 200) {
				String line = reader.readLine();
				while (line != null && line.length() > 0) {
					sBuilder.append(line);
					line = reader.readLine();

				}
				return sBuilder.toString();
			} else {
				Log.i("getDateByHttpConnection", "you havn't connete");
			}
			reader.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "warn";
	}

	/**
	 * 通过获取到的json 初始化list1;
	 * 
	 * @author jkqme
	 * 
	 */
	class DealJson {

		/**
		 * @获取好友列表和群列表的类，有线程安全问题
		 * @param source
		 *            获取的json 字符串
		 * @param isFriend
		 *            source 是否为朋友列表的字符串
		 */
		public DealJson(String source, boolean isFriend) {
			JSONArray json = null;
			synchronized (DealJson.class) {
				if (isFriend) {
					try {
						// 实例化json
						json = new JSONArray(source);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					getDateList1(json);
				} else {
					try {
						json = new JSONArray(source);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					getDateList2(json);
				}
			}

		}

		// 初始化list1
		private void getDateList1(JSONArray json) {
			HashMap<String, String> map;
			for (int i = 0; i < json.length(); i++) {
				map = new HashMap<String, String>();

				try {
					map.put("textView",
							json.getJSONObject(i).getString("frienname"));
					map.put("img", json.getJSONObject(i).getString("friendimg"));
					list1.add(map);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// 获取好友群列表
		private void getDateList2(JSONArray json) {
			HashMap<String, String> map;
			for (int i = 0; i < json.length(); i++) {
				map = new HashMap<String, String>();
				try {
					map.put("textView",
							json.getJSONObject(i).getString("socialname"));
					map.put("img", json.getJSONObject(i).getString("socialimg"));
					list2.add(map);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		// 返回2的时候有效

		if (resultCode == 2) {
			boolean isfriend = data.getExtras().getBoolean("isFriend");
			if (isfriend) {

				list1.removeAll(list1);
				String friendDate = getDateByHttpConnection(ip + NetUrl.friend
						+ chekAll);
				// Log.i("result==>Asy", friendDate);

				Log.i("friendAsy", friendDate);

				DealJson dJson = new DealJson(friendDate, true);
				if (adpter != null) {
					adpter.notiChange(list1);

					Log.i("list1", "不为空");
				}
			} else {
				list2.removeAll(list2);
				String friendDate = getDateByHttpConnection(ip + NetUrl.friend
						+ chekAlls);
				// Log.i("result==>Asy", friendDate);
				Log.i("socialAsy", friendDate);

				DealJson dJson = new DealJson(friendDate,false);
				if (adpter2 != null) {
					adpter2.notiChange(list2);
				}
			}
		}
	}
}
