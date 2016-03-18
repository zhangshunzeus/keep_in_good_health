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
*   ����ǳ����������   ����֮���Զ����������
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
	private RadioGroup group; // ������radiogroup
	private FragmentManager fragmentManager; // fragment�Ĺ�����
	private android.support.v4.app.FragmentTransaction transaction; // fragment�Ĵ�����
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private HomepageFragment homeFragment; // ���ص���ҳ����Fragment
	private MyFragment myfragment; // ���ص��ҵİ���Fragment
	private SortFragment sortFragment; // ���صķ������Fragment

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		loadFragmentIniv();

	}

	// ����ǳ�ʼ����button��fragment��һЩ������
	private void loadFragmentIniv() {
		group = (RadioGroup) findViewById(R.id.radio_group);
		group.setOnCheckedChangeListener(this);
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		homeFragment = new HomepageFragment();
		transaction.add(R.id.main_fragment_line, homeFragment);
		transaction.commit();

	}

	// ���RadioButton���л�fragment���¼�
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		switch (checkedId) {
		case R.id.home_page: // �����ҳ�л���Fragment
			homeFragment = new HomepageFragment();
			transaction.replace(R.id.main_fragment_line, homeFragment);
			// transaction.hide(homeFragment).show(homeFragment);

			break;
		case R.id.classify: // ��������л���Fragment,�ǵ��Ժ��Ҫ���ʵ���������
			sortFragment = new SortFragment();
			transaction.replace(R.id.main_fragment_line, sortFragment);
			break;
		case R.id.circle: // ������л���Fragment
			myfragment = new MyFragment();
			transaction.replace(R.id.main_fragment_line, myfragment);
			// transaction.hide(myfragment).hide(myfragment);

			break;
		}
		transaction.commit();

	}
}