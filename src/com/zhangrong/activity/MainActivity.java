package com.zhangrong.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.widget.RadioGroup;
import com.zhangrong.fragment.HomepageFragment;
import com.zhangrong.fragment.MyFragment;
import com.zhangrong.fragment.SortFragment;
import com.zhangshun.keep_in_good_health.R;
import java.util.ArrayList;
/*
*   这个是程序的主界面   进入之后，自动加载这个类
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
	private RadioGroup group; // 这界面的radiogroup
	private FragmentManager fragmentManager; // fragment的管理者
	private android.support.v4.app.FragmentTransaction transaction; // fragment的处理者
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private HomepageFragment homeFragment = new HomepageFragment(); // 加载的首页板块的Fragment
	private MyFragment myfragment = new MyFragment(); // 加载的我的板块的Fragment
	private SortFragment sortFragment = new SortFragment(); // 加载的分类板块的Fragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		loadFragmentIniv();
	}

	// 这个是初始化，button和fragment的一些工作的
	private void loadFragmentIniv() {
		group = (RadioGroup) findViewById(R.id.radio_group);
		group.setOnCheckedChangeListener(this);
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		homeFragment = new HomepageFragment();
		transaction.add(R.id.main_fragment_line, homeFragment, "homeFragment");
		transaction.add(R.id.main_fragment_line, myfragment, "myFragment");
		transaction.add(R.id.main_fragment_line, sortFragment, "sortFragment");
		transaction.commitAllowingStateLoss();
	}

	// 点击RadioButton的切换fragment的事件
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();

		if (homeFragment != null) {
			transaction.hide(homeFragment);
		}
		if (sortFragment != null) {
			transaction.hide(sortFragment);
		}
		if (myfragment != null) {
			transaction.hide(myfragment);
		}

		switch (checkedId) {
		case R.id.home_page: // 点击首页切换的Fragment

			if (homeFragment == null) {
				homeFragment = new HomepageFragment();
				transaction.add(R.id.main_fragment_line, homeFragment, "homeFragment");

			} else {
				transaction.show(homeFragment);
			}

			break;
		case R.id.classify: // 点击分类切换的Fragment,记得以后改要点击实体的主界面

			if (sortFragment == null) {
				sortFragment = new SortFragment();
				transaction.add(R.id.main_fragment_line, sortFragment, "sortFragment");

			} else {
				transaction.show(sortFragment);
			}

			break;
		case R.id.circle: // 点击我切换的Fragment

			if (myfragment == null) {
				myfragment = new MyFragment();
				transaction.add(R.id.main_fragment_line, myfragment, "myFragment");

			} else {
				transaction.show(myfragment);
			}

			break;
		}
		transaction.commitAllowingStateLoss();

	}

	// 这是对fragemet的转屏操作，用来恢复，fragment的方法。
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			homeFragment = (HomepageFragment) fragmentManager.getFragment(savedInstanceState, "homeFragment");
			sortFragment = (SortFragment) fragmentManager.getFragment(savedInstanceState, "sortFragment");
			myfragment = (MyFragment) fragmentManager.getFragment(savedInstanceState, "myFragment");

		}

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		fragmentManager = getSupportFragmentManager();
		fragmentManager.putFragment(outState, "homeFragment", homeFragment);
		fragmentManager.putFragment(outState, "sortFragment", sortFragment);
		fragmentManager.putFragment(outState, "myFragment", myfragment);
	}
}