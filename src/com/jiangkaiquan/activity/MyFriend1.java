package com.jiangkaiquan.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
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

import com.jiangkaiquan.activity.adapter.MyFriend1Ad;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.HashMap;

import com.jiangkaiquan.activity.adapter.RecomendAdapter;

/**
 * Created by jkqme on 2016/3/14.
 * <p/>
 * MyFriend 的更新
 */
public class MyFriend1 extends Activity {
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
    private ArrayList<HashMap<String, Object>> list;
    private ArrayList<HashMap<String, Object>> list2;

    private RelativeLayout layout;
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    WindowManager.LayoutParams lp;


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
        getFriendDate();
        getSocialDate();
        listview = (ListView) findViewById(R.id.myfrend1_lv);
        listView2 = (ListView) findViewById(R.id.myfrend1_1v2);
        adpter = new MyFriend1Ad(list, this, true);
        adpter2 = new MyFriend1Ad(list2, this, false);
        Log.i("onCreate", "listview");
        listview.setAdapter(adpter);
        listView2.setAdapter(adpter2);

        back.setOnClickListener(listener);
        add.setOnClickListener(listener);
        friend.setOnClickListener(listener);

        social.setOnClickListener(listener);


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //dissmis popuwind
            if (pwind != null && pwind.isShowing()) {
                pwind.dismiss();
            }
            switch (view.getId()) {
                case R.id.myfriend1_back_img:
                	finish();
                    break;
                case R.id.myfriend1_add_img:
                    showDiolog();
                    break;
                case R.id.myfriend1_friend_tx:
                    friend.setTextColor(getResources().getColor(R.color.friendbt_change));
                    social.setTextColor(getResources().getColor(R.color.frendbt_no_change));
                    listview.setVisibility(View.VISIBLE);

                    listView2.setVisibility(View.GONE);
                   view1.setVisibility(View.VISIBLE);
                   view2.setVisibility(View.INVISIBLE);
                    break;
                case R.id.myfriend1_social_tx:
                    social.setTextColor(getResources().getColor(R.color.friendbt_change));
                    friend.setTextColor(getResources().getColor(R.color.frendbt_no_change));
                    view2.setVisibility(View.VISIBLE);
                    view1.setVisibility(View.INVISIBLE);

                    listView2.setVisibility(View.VISIBLE);
                    listview.setVisibility(View.GONE);
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

    private void displayPopuwind() {
        if (pwind == null) {
            int id[] = {R.id.friend_swap_tx, R.id.friend_add_tx, R.id.friend_creat_social_tx};
            View view = LayoutInflater.from(this).inflate(R.layout.jiang_popwind_my_friend, null);
            TextView text;
            for (int i = 0; i < id.length; i++) {
                text = (TextView) view.findViewById(id[i]);
                text.setSelected(true);
                text.setOnClickListener(listener);
            }
            //显示popuwind
            pwind = new PopupWindow(view);

            //加pupowind页面
            // pwind.setContentView(view);
            pwind.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            pwind.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        pwind.showAsDropDown(layout);

        pwind.setOnDismissListener(ondismis);
    }

    //不显示接口
    private PopupWindow.OnDismissListener ondismis = new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {

        }
    };

    //设置diolog
    private void showDiolog() {
        if (dialog == null) {
            //dialog 弹出窗试图
            int id[] = {R.id.friend_swap_tx, R.id.friend_add_tx, R.id.friend_creat_social_tx};
            View view = LayoutInflater.from(this).inflate(R.layout.jiang_popwind_my_friend, null);
            TextView text;
            for (int i = 0; i < id.length; i++) {
                text = (TextView) view.findViewById(id[i]);
                text.setSelected(true);
                text.setOnClickListener(listener);
            }
            //dialog位置设置
            int w = layout.getWidth();
            int h = layout.getHeight();
            builder = new AlertDialog.Builder(this);
            builder.setView(view);
            dialog = builder.create();
            //  dialog.setContentView(R.layout.jiang_popwind_my_friend);

            //获得当前窗体
            Window window = dialog.getWindow();

            //重新设置
            lp = window.getAttributes();
            window.setGravity(Gravity.RIGHT | Gravity.TOP);
            lp.x = 200; // 新位置X坐标
            lp.y = 200; // 新位置Y坐标
            lp.width = ViewGroup.LayoutParams.WRAP_CONTENT; // 宽度
            lp.height = ViewGroup.LayoutParams.WRAP_CONTENT; // 高度
            //lp.alpha = 0.7f; // 透明度

            // dialog.onWindowAttributesChanged(lp);
            //(当Window的Attributes改变时系统会调用此函数)
            window.setAttributes(lp);
        }
        //builder.notify();
        dialog.show();

    }

    //我的好友数据
    private void getFriendDate() {
        HashMap<String, Object> map;
        list = new ArrayList<HashMap<String, Object>>();

        int imgId[] = {R.drawable.friend1, R.drawable.friend2, R.drawable.friend3, R.drawable.friend4, R.drawable.friend5, R.drawable.friend6, R.drawable.friend7, R.drawable.friend8};
        String text[] = {"重我最帅", "fdsa", "我来拯救地球", "美女", "较比手好用", "哈", "天王", "着了"};
        for (int i = 0; i < imgId.length; i++) {
            map = new HashMap<String, Object>();
            map.put("img", imgId[i]);
            map.put("text", text[i]);
            list.add(map);
        }

    }

    //我的群数据
    private void getSocialDate() {
        HashMap<String, Object> map;
        list2 = new ArrayList<HashMap<String, Object>>();
        int imgId[] = {R.drawable.social1, R.drawable.social2, R.drawable.social3, R.drawable.social6};
        String text[] = {"健康", "美丽", "运动", "90后"};
        for (int i = 0; i < imgId.length; i++) {
            map = new HashMap<String, Object>();
            map.put("img", imgId[i]);
            map.put("text", text[i]);
            list2.add(map);
        }
    }
}
