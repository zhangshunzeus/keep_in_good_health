package com.zhangrong.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.zhangshun.keep_in_good_health.R;

/**
 * 这个类是 主页板块的主的fragment 它加载的主页板块的布局
 * 
 * @创建时间 2016-03-10
 */
public class SortFragment extends android.support.v4.app.Fragment implements
		RadioGroup.OnCheckedChangeListener {
	private android.support.v4.app.FragmentManager manager;
	private android.support.v4.app.FragmentTransaction tran;
	private SortFragmentRight righet;
	private RadioGroup group;
 
	private SortFragmentRighX righX;
	private RadioButton radio3;
	private RadioButton radio1;
	private RadioButton radio2;
	private RadioButton radio4;
	private RadioButton radio5;
	private RadioButton radio6;
	private RadioButton radio7;
	private RadioButton radio8;
	private RadioButton radio9;
	private RadioButton radio10;
	private RadioButton radio11;
	private RadioButton radio12;
	private SortFragmentRightTwo rightetTwo;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.sort_fragment, container, false);
		group = (RadioGroup) view.findViewById(R.id.sort_left_group);
		radio3 = (RadioButton) view.findViewById(R.id.sort_left_radio3);
		radio2 = (RadioButton) view.findViewById(R.id.sort_left_radio2);
		radio1 = (RadioButton) view.findViewById(R.id.sort_left_radio1);
		radio4 = (RadioButton) view.findViewById(R.id.sort_left_radio4);
		radio5 = (RadioButton) view.findViewById(R.id.sort_left_radio5);
		radio6 = (RadioButton) view.findViewById(R.id.sort_left_radio6);
		radio7 = (RadioButton) view.findViewById(R.id.sort_left_radio7);
		radio8 = (RadioButton) view.findViewById(R.id.sort_left_radio8);
		radio9 = (RadioButton) view.findViewById(R.id.sort_left_radio9);
		radio10 = (RadioButton) view.findViewById(R.id.sort_left_radio10);
		radio11 = (RadioButton) view.findViewById(R.id.sort_left_radio11);
		radio12 = (RadioButton) view.findViewById(R.id.sort_left_radio12);
		group.setOnCheckedChangeListener(this);
		inivFragment();
		return view;
	}

	private void inivFragment() {
		manager = getFragmentManager();
		tran = manager.beginTransaction();
		righet = new SortFragmentRight();
		radio1.setTextSize(12);
		tran.add(R.id.sortfragment_regit_line, righet);

		tran.commit();

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		Log.i("log", "sortRaio选择被执行");
		manager = getFragmentManager();
		tran = manager.beginTransaction();
		if (rightetTwo != null) {
			tran.hide(rightetTwo);
		}
		if (righX != null) {
			tran.hide(righX);
		}
		if (righet != null) {
			tran.hide(righet);
		}
		switch (checkedId) {
		case R.id.sort_left_radio2:
			radio1.setTextSize(8);
			radio3.setTextSize(8);
			radio2.setTextSize(12);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio8.setTextSize(8);
			radio7.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (rightetTwo == null) {
				rightetTwo = new SortFragmentRightTwo();
				tran.add(R.id.sortfragment_regit_line, rightetTwo);

			} else {
				tran.show(rightetTwo);
			}

			break;
		case R.id.sort_left_radio1:
			radio1.setTextSize(12);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);

			if (righet == null) {
				righet = new SortFragmentRight();
				tran.add(R.id.sortfragment_regit_line, righet);

			} else {
				tran.show(righet);
			}

			break;
		case R.id.sort_left_radio3:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(12);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}

			break;
		case R.id.sort_left_radio4:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(12);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}
			break;
		case R.id.sort_left_radio5:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(12);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righet == null) {
				righet = new SortFragmentRight();
				tran.add(R.id.sortfragment_regit_line, righet);

			} else {
				tran.show(righet);
			}

			break;
		case R.id.sort_left_radio6:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(12);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}
			break;
		case R.id.sort_left_radio7:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(12);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}
			break;
		case R.id.sort_left_radio8:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(12);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righet == null) {
				righet = new SortFragmentRight();
				tran.add(R.id.sortfragment_regit_line, righet);

			} else {
				tran.show(righet);
			}

			break;
		case R.id.sort_left_radio9:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(12);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}
			break;
		case R.id.sort_left_radio10:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(12);
			radio11.setTextSize(8);
			radio12.setTextSize(8);
			if (righet == null) {
				righet = new SortFragmentRight();
				tran.add(R.id.sortfragment_regit_line, righet);

			} else {
				tran.show(righet);
			}

			break;
		case R.id.sort_left_radio11:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(12);
			radio12.setTextSize(8);
			if (righet == null) {
				righet = new SortFragmentRight();
				tran.add(R.id.sortfragment_regit_line, righet);

			} else {
				tran.show(righet);
			}

			break;
		case R.id.sort_left_radio12:
			radio1.setTextSize(8);
			radio2.setTextSize(8);
			radio3.setTextSize(8);
			radio4.setTextSize(8);
			radio5.setTextSize(8);
			radio6.setTextSize(8);
			radio7.setTextSize(8);
			radio8.setTextSize(8);
			radio9.setTextSize(8);
			radio10.setTextSize(8);
			radio11.setTextSize(8);
			radio12.setTextSize(12);
			if (righX == null) {
				righX = new SortFragmentRighX();
				tran.add(R.id.sortfragment_regit_line, righX);

			} else {
				tran.show(righX);
			}
			break;
		}
		Log.i("log", "sort选择方法被执行:id为" + checkedId);
		tran.commit();

	}

}
