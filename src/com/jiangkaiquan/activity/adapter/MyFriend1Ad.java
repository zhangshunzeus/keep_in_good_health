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

import com.zhangshun.keep_in_good_health.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
 */
public class MyFriend1Ad extends BaseAdapter {
	ArrayList<HashMap<String, Object>> list;

	ArrayList<HashMap<String, Object>> list1 = new ArrayList<HashMap<String, Object>>();
	// 记录加载过的试图
	ArrayList<Hashget> list2 = new ArrayList<Hashget>();
	Context context;
	LayoutInflater inflater;
	boolean isfreind;
	String ip = "127.0.0.1";
	String addDate = "addDate";
	String addDates = "addDstes";
	String addAll = "addAll";
	String addAlls = "addAlls";
	String chekAll = "chekAll";
	String chekAlls = "chekAlls";

	public MyFriend1Ad() {

	}

	public MyFriend1Ad(ArrayList<HashMap<String, Object>> list,
			Context context, boolean isfreind) {
		this.context = context;
		this.list = list;
		this.isfreind = isfreind;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int i) {
		return list.get(i);
	}

	@Override
	public long getItemId(int i) {
		return i;
	}

	@Override
	public View getView(int i, View view, ViewGroup viewGroup) {
		Holder holder;
		Log.i("getView", getCount() + "");
		if (view == null) {
			Log.i("getView", "adpter==null");
			holder = new Holder();
			view = inflater.inflate(R.layout.friend_child, null);
			holder.textView = (TextView) view
					.findViewById(R.id.friend_child_tx);
			holder.img = (ImageView) view.findViewById(R.id.friend_child_img);
			holder.img1 = (ImageView) view
					.findViewById(R.id.friend_child_right_img);
			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();
			Log.i("getView", "adpter==null");
		}
		holder.img.setImageDrawable(view.getResources().getDrawable(
				(Integer) list.get(i).get("img")));
		holder.textView.setText((String) list.get(i).get("text"));
		if (!isfreind) {
			holder.img1.setVisibility(View.VISIBLE);
		}
		return view;
	}

	// @Override
	public View getVie(int i, View view, ViewGroup viewGroup) {
		Holder holder;
		if (view == null) {
			holder = new Holder();
			view = inflater.inflate(R.layout.friend_child, null);
			holder.textView = (TextView) view
					.findViewById(R.id.friend_child_tx);
			holder.img = (ImageView) view.findViewById(R.id.friend_child_img);
			holder.img1 = (ImageView) view
					.findViewById(R.id.friend_child_right_img);
			
			holder.setPosition(i);
			view.setTag(holder);
		} else {
			holder = (Holder) view.getTag();
			
			// 设置位置
		}
		// 添加数据
					if (list2.size() <= 0) {
						list2.add(new Hashget());
					
						holder.setPosition(i);
					}
		holder.img.setImageBitmap((Bitmap) list1.get(i).get("img"));
		holder.textView.setText((String) list1.get(i).get("text"));
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
		MyAsy asy = new MyAsy();
		// 是否已经获取了一次
		boolean hasget = false;
		int position;
		Bitmap bit;
		JSONObject json;

		// 设置当前位置，通过本方法实现对子view的加载判断
		public void setPosition(int position) {
			this.position = position;
			// 添加数据
			if (!list2.get(position).isget) {
				MyAsy asy = new MyAsy();
				// 或取数据
				asy.execute(chekAll);
				list2.get(position).isget=true;
			}
		}

		/**
		 * 处理异步任务的类
		 * 
		 * @author jkqme 1.获取信息 2.处理jsonArray 3.获取json 内的朋友名信息，和头像地址，4.设置朋友名
		 *         和获取图片，异步设置图片
		 */
		@TargetApi(Build.VERSION_CODES.CUPCAKE)
		class MyAsy extends AsyncTask<String, String, String> {
			@Override
			protected String doInBackground(String... params) {
				// TODO Auto-generated method stub params excute传人的字符串数组
				String str = params[0];
				// String result = WebManger.getDateByHttpConnection(str, null);
				String result = getDateByHttpConnection(ip + NetUrl.friend
						+ chekAll);
				DealJson dJson = new DealJson(result);
				// 或取单个pengyou信息
				json = dJson.getFriend(position);
				try {
					// 获取朋友名
					result = dJson.getFriend(position).getString("frienName");
					bit = getBit(ip + json.getString("friendImg"));
					// 设置头像
					img.setImageBitmap(bit);

					// 向list1添加数据
					HashMap<String, Object> map = new HashMap<String, Object>();
					map.put("img", bit);
					map.put("textView", result);
					list1.add(map);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return result;// 获取网络访问返回的数组
			}

			@TargetApi(Build.VERSION_CODES.CUPCAKE)
			@Override
			protected void onPostExecute(String result) {
				// TODO Auto-generated method stub
				textView.setText(result);

				super.onPostExecute(result);
			}
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

				connection.connect();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(connection.getInputStream()));
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

		// 下载图片 耗时
		private Bitmap getBit(String urls) {
			final String imageUrl = urls;
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
	}

	class DealJson {
		JSONArray json;

		// 获取的数据为json array
		public DealJson(String source) {
			try {
				// 实例化json
				json = new JSONArray(source);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 返回一个jsonObject的类，这个类包含了朋友名和头像地址
		public JSONObject getFriend(int i) {

			JSONObject jsons = null;
			try {
				jsons = json.getJSONObject(i);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jsons;
		}
	}

	class Hashget {
		boolean isget = false;
	}
}
