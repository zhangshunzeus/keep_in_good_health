package com.zhangrong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangrong.example.MealnameInfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * Created by zhang on 2016/3/8.
 */
public class MealnameListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MealnameInfo> mealnameData;

    public MealnameListAdapter(Context context, ArrayList<MealnameInfo> mealnameData) {
        this.context = context;
        this.mealnameData = mealnameData;

    }

    @Override
    public int getCount() {
        return 1;
    }

    @Override
    public Object getItem(int position) {
        return mealnameData.get(position);
    }


    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHloder viewHloder;
        if (convertView == null) {
            viewHloder = new ViewHloder();
            convertView = LayoutInflater.from(context).inflate(R.layout.meal_name_listview_iteml, null);
            viewHloder.meal_name_show_image = (ImageView) convertView.
                    findViewById(R.id.meal_name_show_image);
            viewHloder.food_iamge_one = (ImageView) convertView.
                    findViewById(R.id.food_iamge_one);
            viewHloder.food_text_one = (TextView) convertView.
                    findViewById(R.id.food_text_one);
            viewHloder.food_iamge_two = (ImageView) convertView.
                    findViewById(R.id.food_iamge_two);
            viewHloder.food_text_two = (TextView) convertView.
                    findViewById(R.id.food_text_two);
            viewHloder.food_iamge_three = (ImageView) convertView.
                    findViewById(R.id.food_iamge_three);
            viewHloder.food_text_three = (TextView) convertView.
                    findViewById(R.id.food_text_three);
            viewHloder.meal_name_Liao_text = (TextView) convertView.
                    findViewById(R.id.meal_name_Liao_text);
            viewHloder.meal_name_dosing_text = (TextView) convertView.
                    findViewById(R.id.meal_name_dosing_text);
            viewHloder.meal_name_practice_text = (TextView) convertView.
                    findViewById(R.id.meal_name_practice_text);
            convertView.setTag(viewHloder);
        } else {
            viewHloder = (ViewHloder) convertView.getTag();
        }
        //设置控制
        MealnameInfo info = mealnameData.get(position);
        viewHloder.meal_name_show_image.setImageResource(info.getMeal_name_show_image());
        viewHloder.food_iamge_one.setImageResource(info.getFood_iamge_one());
        viewHloder.food_iamge_two.setImageResource(info.getFood_iamge_two());
        viewHloder.food_iamge_three.setImageResource(info.getFood_iamge_three());
        viewHloder.food_text_one.setText(info.getFood_text_one());
        viewHloder.food_text_two.setText(info.getFood_text_two());
        viewHloder.food_text_three.setText(info.getFood_text_three());
        viewHloder.meal_name_Liao_text.setText(info.getMeal_name_Liao_text());
        viewHloder.meal_name_dosing_text.setText(info.getMeal_name_dosing_text());
        viewHloder.meal_name_practice_text.setText(info.getMeal_name_practice_text());

        return convertView;
    }

    public class ViewHloder {
        private ImageView meal_name_show_image;
        private ImageView food_iamge_one;
        private TextView food_text_one;
        private ImageView food_iamge_two;
        private TextView food_text_two;
        private ImageView food_iamge_three;
        private TextView food_text_three;
        private TextView meal_name_Liao_text;
        private TextView meal_name_dosing_text;
        private TextView meal_name_practice_text;

    }
}
