package com.jiangkaiquan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.HashMap;

import com.jiangkaiquan.activity.adapter.MyFriendsAdapter;

/**
 * 我的朋友页面,有更新,请看MyFriend1
 * Created by jkqme on 2016/3/9.
 */
public class OldFriend extends Activity {
    private ImageView back;
    private ImageView add;
    private AutoCompleteTextView auoText;
    private TextView newFriend;
    private TextView issuGroup;
    private TextView care;
    private ExpandableListView eview;
    private PopupWindow pwind;
    private MyFriendsAdapter eadpter = new MyFriendsAdapter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiang_my_friend);
        lodVary();
        loadAuto();
        loadeAdpter();
    }

    private void lodVary() {
        back = (ImageView) findViewById(R.id.my_friend_back_img);
        add = (ImageView) findViewById(R.id.my_friend_add_img);
        auoText = (AutoCompleteTextView) findViewById(R.id.my_friend_atx);
        newFriend = (TextView) findViewById(R.id.my_friend_new_tx);
        issuGroup = (TextView) findViewById(R.id.my_friend_issue_group_tx);
        care = (TextView) findViewById(R.id.my_friend_car_tx);
        eview = (ExpandableListView) findViewById(R.id.my_friend_exlist);

        back.setOnClickListener(listener);
        add.setOnClickListener(listener);
        newFriend.setOnClickListener(listener);
        issuGroup.setOnClickListener(listener);
        care.setOnClickListener(listener);

        //pwind = new PopupWindow(this);


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            pwind.dismiss();
            switch (view.getId()) {
                case R.id.my_friend_add_img:
                    displayPopuwind();
                    break;

                case R.id.my_friend_back_img:

                    break;

                case R.id.my_friend_new_tx:
                    break;
                case R.id.my_friend_issue_group_tx:

                    break;
                case R.id.my_friend_car_tx:
                    break;
                case R.id.friend_swap_tx:
                    break;
                case R.id.friend_add_tx:
                    break;
                case R.id.friend_creat_social_tx:
                    break;
            }

        }
    };

    //加载expandleListview
    private void loadeAdpter() {
        String str[] = {"一", "二", "三", "四", "五", "六", "七", "八", "九"};
        ArrayList<String> parents = new ArrayList<String>();
        for (String a : str) {
            parents.add(a);
        }
        HashMap<String, ArrayList<Object>> map = new HashMap<String, ArrayList<Object>>();
        eadpter = new MyFriendsAdapter(parents, map, this);
        eview.setAdapter(eadpter);
    }

    //加载AutoCompletEcittext
    private void loadAuto() {
        String str[] = {"aaa", "a", "aaaa", "aaaaa"};
        ArrayAdapter<String> adpter;
        adpter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        auoText.setAdapter(adpter);
    }

    private void displayPopuwind() {
        if (pwind == null) {
            int id[] = {R.id.friend_swap_tx, R.id.friend_add_tx, R.id.friend_creat_social_tx};
            View view = LayoutInflater.from(this).inflate(R.layout.jiang_popwind_my_friend, null);
            TextView text;
            for (int i = 0; i < id.length; i++) {
                text = (TextView) view.findViewById(id[i]);
                text.setOnClickListener(listener);
            }
            //显示popuwind
            pwind = new PopupWindow(view);

            //加pupowind页面
            // pwind.setContentView(view);
            pwind.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            pwind.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        pwind.showAsDropDown(issuGroup);
    }
}
