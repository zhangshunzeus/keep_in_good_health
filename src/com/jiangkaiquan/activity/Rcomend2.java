package com.jiangkaiquan.activity;

import javax.security.auth.PrivateCredentialPermission;

import android.R.integer;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ruanjiawei.activity.LoginActivity;
import com.umeng.socialize.net.v;
import com.zhangshun.keep_in_good_health.R;

/**
 * Created by jkqme on 2016/3/14.
 */
@SuppressLint("NewApi")
public class Rcomend2 extends Activity {
	// 页面
	@SuppressLint("NewApi")
	private Fragment recomend = new Fragment() {
		// 底部button
		private TextView button[] = new TextView[3];
		private int buttonId[] = { R.id.my_friend_new_tx,
				R.id.my_friend_issue_group_tx, R.id.my_friend_car_tx };
		private TextView back;
		// 子项标题
		private TextView child[] = new TextView[4];
		private TextView child1;
		private TextView child2;
		private TextView child3;
		// 子项说明
		private TextView fruit[] = new TextView[5];
		private TextView fruit2;
		private TextView fruit2_1;
		private TextView fruit3;
		private TextView fruit4;
		// 子项图片
		private ImageView food[] = new ImageView[5];
		private ImageView food1;
		private ImageView food2;
		private ImageView food2_1;
		private ImageView food3;
		// 子项标题
		private int childId[] = { R.id.recomend_chirld_name_tx,
				R.id.recomend_chirld1_name_tx, R.id.recomend_chirld3_name_tx,
				R.id.recomend_chirld4_name_tx };
		// 子项说明
		private int fruitId[] = { R.id.recomend_friut_tx,
				R.id.recomend_friut1_tx, R.id.recomend_friut3_tx,
				R.id.recomend_friut3_1_tx, R.id.recomend_friut4_tx };
		// 子项图片
		private int foodId[] = { R.id.recomend2_food_img,
				R.id.recomend2_food1_img, R.id.recomend2_food3_img,
				R.id.recomend2_food3_1_img, R.id.recomend2_food4_img, };

		// 加载控件
		private void load(View view) {

			for (int i = 0, j = 0; i < 4; i++, j++) {
				child[i] = (TextView) view.findViewById(childId[i]);
				fruit[j] = (TextView) view.findViewById(fruitId[j]);
				food[j] = (ImageView) view.findViewById(foodId[j]);
				food[j].setOnClickListener(listener);
				// 底部button实例化
				/*
				 * if (i < 3) { button[i] = (TextView)
				 * view.findViewById(buttonId[i]);
				 * button[i].setOnClickListener(listener); }
				 */
				// 多余项实例
				if (i == 3) {
					j++;
					fruit[j] = (TextView) view.findViewById(fruitId[j]);
					food[j] = (ImageView) view.findViewById(foodId[j]);
				}
			}
		}

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.recomend2_food_img:
					jump(0);
					onShow = 0;
					break;
				case R.id.recomend2_food1_img:
					jump(0);
					onShow = 1;
					break;
				case R.id.recomend2_food3_img:
					jump(0);
					onShow = 2;
					break;
				case R.id.recomend2_food3_1_img:
					jump(0);
					onShow = 3;
					break;
				case R.id.recomend2_food4_img:
					jump(0);
					onShow = 4;
					break;
				default:
					break;
				}
			}
		};

		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View view = inflater.inflate(R.layout.jiang_recomend_2, null);
			load(view);
			Log.i("recomend", "==================================");
			return view;
		};
	};

	// ++++++++++++++++Activity 方法++++++++++++++++++++++++++++++++++++++++++
	private FragmentManager manager = getFragmentManager();
	private FragmentTransaction transaction;
	private int onShow = -1;// 显示的item

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jiang_recoment_2);
		jump(1);
	}

	// private void
	// display(){Toast.makeText(this,"可以使用",Toast.LENGTH_LONG).show();}
	// 设置用来显示的页面
	private void jump(int a) {
		transaction = manager.beginTransaction();
		transaction.add(R.id.recomend_2_layout, recomend);
		transaction.add(R.id.recomend_2_layout, recomendChrild);
		if (a == 1) {
			transaction.hide(recomendChrild);
			transaction.show(recomend);
			transaction.commit();
		} else {
			transaction.hide(recomend);
			transaction.show(recomendChrild);
			transaction.commit();
		}
	}

	// 子类
	@SuppressLint("NewApi")
	private Fragment recomendChrild = new Fragment() {
		TextView title;
		TextView context;
		ImageView back;

		@Override
		public void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub

			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View view = inflater.inflate(R.layout.jiangkaiquan_recomend_chrild,
					null);
			load(view);
			return view;
		}

		private void load(View view) {
			title = (TextView) view.findViewById(R.id.recomend_chrild_title_tx);
			context = (TextView) view
					.findViewById(R.id.recomend_chrild_context_tx);
			back = (ImageView) view.findViewById(R.id.recomend_chrild_back_img);
			back.setOnClickListener(listener);
		}

		@Override
		public void onResume() {
			// TODO Auto-generated method stub
			onShow(onShow);
			super.onResume();
		}

		public void onShow(int viewId) {
			switch (viewId) {
			case 0:

				break;
			case 1:

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;

			default:
				break;
			}
		}

		OnClickListener listener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.recomend_chrild_back_img:
					jump(1);
					break;

				default:
					break;
				}

			}
		};
	};
}
