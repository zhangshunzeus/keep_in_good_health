package com.jiangkaiquan.activity.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.AsyncTask;
import android.os.Build;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.a.a.a.d;
import com.zhangshun.keep_in_good_health.R;

import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jkqme on 2016/3/14.
 */

/**
 * Created by jkqme on 2016/3/14.
 */
public class MyFriend1Ad extends BaseAdapter {
	// 默认头像
	String defult = "defult";

	ArrayList<HashMap<String, Object>> list;
	// 记录数据
	ArrayList<HashMap<String, String>> list1 = new ArrayList<HashMap<String, String>>();
	// 记录加载过的试图
	ArrayList<Bitmap> list2 = new ArrayList<Bitmap>();
	Context context;
	LayoutInflater inflater;
	boolean isfreind;
	// 朋友页面的json字符串
	String friendDate = null;
	// 群的json字符串
	String socialDate = null;
	String ip = NetUrl.ip1;
	// String ips="http:";
	String addDate = "addDate";
	String addDates = "addDstes";
	String addAll = "addAll";
	String addAlls = "addAlls";
	String chekAll = "chekAll";
	String chekAlls = "chekAlls";
	boolean hasget = false;
	Bitmap defultBitmap;

	public MyFriend1Ad() {

	}

	public MyFriend1Ad(ArrayList<HashMap<String, String>> list,
			Context context, boolean isfreind) {
		this.context = context;
		this.list1 = list;
		this.isfreind = isfreind;
		inflater = LayoutInflater.from(context);
		MyAsy asy = new MyAsy();
		asy.execute(chekAll);
		defultBitmap = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.friend1);

	}

	// 获取头像完成后调用
	private void notifyss() {
		this.notifyDataSetChanged();
	}

	// 添加好友或群后调用
	public void notiChange(ArrayList<HashMap<String, String>> list) {
		this.list1 = list;
		list2.removeAll(list2);
		MyAsy asy = new MyAsy();
		asy.execute(chekAll);
		Log.i("notiChange", "重新设置了数据");
	}

	@Override
	public int getCount() {
		return list1.size();
	}

	@Override
	public Object getItem(int i) {
		return list1.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	/*
	 * @Override public View getView(int i, View view, ViewGroup viewGroup) {
	 * Holder holder; Log.i("getView", getCount() + ""); if (view == null) {
	 * Log.i("getView", "adpter==null"); holder = new Holder(); view =
	 * inflater.inflate(R.layout.friend_child, null); holder.textView =
	 * (TextView) view .findViewById(R.id.friend_child_tx); holder.img =
	 * (ImageView) view.findViewById(R.id.friend_child_img); holder.img1 =
	 * (ImageView) view .findViewById(R.id.friend_child_right_img);
	 * view.setTag(holder); } else { holder = (Holder) view.getTag();
	 * Log.i("getView", "adpter==null"); }
	 * holder.img.setImageDrawable(view.getResources().getDrawable( (Integer)
	 * list.get(i).get("img"))); holder.textView.setText((String)
	 * list.get(i).get("text")); if (!isfreind) {
	 * holder.img1.setVisibility(View.VISIBLE); } return view; }
	 */

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		Holder holder;

		if (view == null) {
			holder = new Holder();
			view = inflater.inflate(R.layout.friend_child, null);
			holder.textView = (TextView) view
					.findViewById(R.id.friend_child_tx);
			holder.img = (ImageView) view.findViewById(R.id.friend_child_img);
			holder.img1 = (ImageView) view
					.findViewById(R.id.friend_child_right_img);

			// holder.setPosition(i);
			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();

			// 设置位置
		}
		if (list2.size() > i) {
			holder.img.setImageBitmap(list2.get(i));
		}

		holder.textView.setText(list1.get(i).get("textView"));
		if (!isfreind) {
			holder.img1.setVisibility(View.VISIBLE);
		}
		return view;
	}

	/**
	 * 包含异步处理
	 * 
	 * @author jkqme
	 * 
	 */
	class Holder {
		ImageView img;
		TextView textView;
		ImageView img1;
	}

	/**
	 * 处理异步任务的类,属于耗时操作，要网络访问要花去的时间
	 * 
	 * @author jkqme 1.获取信息 2.处理jsonArray 3.获取json 内的朋友名信息，和头像地址，4.设置朋友名
	 *         和获取图片，异步设置图片
	 */
	@TargetApi(Build.VERSION_CODES.CUPCAKE)
	class MyAsy extends AsyncTask<String, String, String> {
		private Holder holder;
		private int posion;
		private Bitmap bit;

		public void setDate(Holder holder, int position) {
			this.holder = holder;
			this.posion = position;
		}

		private void addImg() {
			for (int i = 0; i < list1.size(); i++) {
				// 没有设置头像的情况
				if (list1.get(i).get("img").equals(defult)) {

					list2.add(defultBitmap);
					continue;
				}
				// 设置了头像的情况
				if (list1.get(i).get("img") != null
						&& list1.get(i).get("img") != "") {
					bit = getBit(list1.get(i).get("img"));
					list2.add(bit);
				}

			}
		}

		// 无视if
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub params excute传人的字符串数组
			String str = params[0];
			String result = null;
			addImg();
			// String result = WebManger.getDateByHttpConnection(str, null);
			// 或取单个pengyou信息

			return result;// 获取网络访问返回的数组
		}

		@TargetApi(Build.VERSION_CODES.CUPCAKE)
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			notifyss();
			Log.i("lst2", list2.size() + "" + "  lst1.sise=" + list1.size());
			super.onPostExecute(result);
		}
	}

	/**
	 * 获取头像
	 * 
	 * @param urls
	 *            图片路径
	 * @return 图片
	 */
	private Bitmap getBit(String urls) {
		final String imageUrl = ip + urls;
		Bitmap bit = null;

		// TODO Auto-generated method stub
		try {
			URL url = new URL(imageUrl);

			InputStream inpt = url.openStream();
			// 获取图片
			bit = BitmapFactory.decodeStream(inpt);

			inpt.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bit;
	}

	class Hashget {
		boolean isget = false;
	}
}
