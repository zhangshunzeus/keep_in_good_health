package com.jiangkaiquan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.jiangkaiquan.activity.adapter.MyFriend1Ad;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.Objects;

import com.jiangkaiquan.activity.adapter.RecomendAdapter;

/**
 * Created by jkqme on 2016/3/14.
 * <p/>
 * MyFriend 的更新
 */
public class MyFriend1 extends Activity {
    private ImageView back;
    private ImageView add;
    private TextView friend;
    private TextView social;
    private PopupWindow pwind;
    private ListView listview;
    private MyFriend1Ad adpter;
    private ArrayList<Object>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiang_my_friend_1);
        back = (ImageView) findViewById(R.id.myfriend1_back_img);
        add = (ImageView) findViewById(R.id.myfriend1_add_img);
        friend = (TextView) findViewById(R.id.myfriend1_friend_tx);
        social = (TextView) findViewById(R.id.myfriend1_social_tx);

        getDate();
        listview=(ListView)findViewById(R.id.myfrend1_lv);
        adpter=new MyFriend1Ad(list,this);
        Log.i("onCreate","listview");
        listview.setAdapter(adpter);
        back.setOnClickListener(listener);
        add.setOnClickListener(listener);
        friend.setOnClickListener(listener);

        social.setOnClickListener(listener);


    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //dissmis popuwind
            if (pwind!=null&&pwind.isShowing()) {
                pwind.dismiss();
            }
            switch (view.getId()) {
                case R.id.myfriend1_back_img:
                    break;
                case R.id.myfriend1_add_img:
                    displayPopuwind();
                    break;
                case R.id.myfriend1_friend_tx:
                    friend.setBackgroundResource(R.drawable.freind);
                    social.setBackgroundColor(255255255);
                    break;
                case R.id.myfriend1_social_tx:
                    social.setBackgroundResource(R.drawable.social);
                    friend.setBackgroundColor(255255255);
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
        pwind.showAsDropDown(add);
        pwind.setOnDismissListener(ondismis);
    }
    //不显示接口
    private PopupWindow.OnDismissListener ondismis=new PopupWindow.OnDismissListener() {
        @Override
        public void onDismiss() {

        }
    };
    private void getDate(){
        list=new ArrayList<Object>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
    }
}
