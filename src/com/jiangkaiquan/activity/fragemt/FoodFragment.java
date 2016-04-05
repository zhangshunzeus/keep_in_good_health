package com.jiangkaiquan.activity.fragemt;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import com.zhangwenbin.activity.TodayEat;

/**
 * Created by jkqme on 2016/3/11.
 */
@SuppressLint("NewApi")
public class FoodFragment extends Fragment {
    private View view;
    Button my_friend_issue_group_tx, my_friend_car_tx;
    TextView dietary, intent_food;
 
    @SuppressLint("NewApi")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.jiang_food, null);


        intent_food = (TextView) view.findViewById(R.id.intent_food);


        intent_food.setOnClickListener(listener);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    View.OnClickListener listener = new View.OnClickListener() {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {

                case R.id.intent_food:
                    Intent intent_todayEat = new Intent();
                    intent_todayEat.setClass(getActivity(), TodayEat.class);
                    startActivity(intent_todayEat);
                    break;
                default:
                    break;
            }
        }
    };
}
