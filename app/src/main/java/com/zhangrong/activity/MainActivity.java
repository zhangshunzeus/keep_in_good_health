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
    private RadioGroup group;           //这界面的radiogroup
    private FragmentManager fragmentManager;   //fragment的管理者
    private android.support.v4.app.FragmentTransaction transaction;  //fragment的处理者
    private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
    private HomepageFragment homeFragment;        //加载的首页板块的Fragment
    private MyFragment myfragment;                //加载的我的板块的Fragment
    private SortFragment sortFragment;            //加载的分类板块的Fragment


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        loadFragmentIniv();






    }

    //这个是初始化，button和fragment的一些工作的
    private void loadFragmentIniv() {
        group = (RadioGroup) findViewById(R.id.main_group);
        group.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomepageFragment();
        transaction.add(R.id.main_fragment_line, homeFragment);
        transaction.commit();



    }



   //点击RadioButton的切换fragment的事件
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        switch (checkedId) {
            case R.id.main_group_radio1:  //点击首页切换的Fragment
                homeFragment = new HomepageFragment();
                transaction.replace(R.id.main_fragment_line,homeFragment);
              // transaction.hide(homeFragment).show(homeFragment);

                break;
            case R.id.main_group_radio2:  //点击分类切换的Fragment,记得以后改要点击实体的主界面
                sortFragment=new SortFragment();
                transaction.replace(R.id.main_fragment_line,sortFragment);
                break;
            case R.id.main_group_radio3:  //点击我切换的Fragment
                myfragment = new MyFragment();
               transaction.replace(R.id.main_fragment_line, myfragment);
             //transaction.hide(myfragment).hide(myfragment);

                break;
        }
      transaction.commit();

    }
}