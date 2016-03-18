package com.zhangrong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangrong.example.SortFragmentRightInfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * Created by zhang on 2016/3/10.
 */
public class SortFragmentRightAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SortFragmentRightInfo> data;

    public SortFragmentRightAdapter(Context context, ArrayList<SortFragmentRightInfo> data) {
        this.context = context;
        this.data = data;

    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }


    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.sortfragment_right_item, null);
            viewHolder.sort_right_item_imageText1 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText1);
            viewHolder.sort_right_item_imageText2 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText2);
            viewHolder.sort_right_item_imageText3 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText3);
            viewHolder.sort_right_item_imageText4 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText4);
            viewHolder.sort_right_item_imageText5 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText5);
            viewHolder.sort_right_item_imageText6 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText6);
            viewHolder.sort_right_item_imageText11 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText11);
            viewHolder.sort_right_item_imageText22 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText22);
            viewHolder.sort_right_item_imageText33 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText33);
            viewHolder.sort_right_item_imageText44 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText44);
            viewHolder.sort_right_item_imageText55 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText55);
            viewHolder.sort_right_item_imageText66 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText66);
            viewHolder.sort_right_item_imageText77 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText77);
            viewHolder.sort_right_item_imageText88 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText88);
            viewHolder.sort_right_item_imageText99 = (TextView) convertView.
                    findViewById(R.id.sort_right_item_imageText99);
            viewHolder.sort_right_itme_image1 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image1);
            viewHolder.sort_right_itme_image2 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image2);
            viewHolder.sort_right_itme_image3 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image3);
            viewHolder.sort_right_itme_image4 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image4);
            viewHolder.sort_right_itme_image5 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image5);
            viewHolder.sort_right_itme_image6 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image6);
            viewHolder.sort_right_itme_image11 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image11);
            viewHolder.sort_right_itme_image22 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image22);
            viewHolder.sort_right_itme_image33 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image33);
            viewHolder.sort_right_itme_image44 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image44);
            viewHolder.sort_right_itme_image55 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image55);
            viewHolder.sort_right_itme_image66 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image66);
            viewHolder.sort_right_itme_image77 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image77);
            viewHolder.sort_right_itme_image88 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image88);
            viewHolder.sort_right_itme_image99 = (ImageView) convertView.
                    findViewById(R.id.sort_right_itme_image99);
            viewHolder.sort_right_item_title = (TextView) convertView.findViewById(R.id.sort_right_item_title);
            viewHolder.sort_right_item_title2 = (TextView) convertView.findViewById(R.id.sort_right_item_title2);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //对控件进行控制
        SortFragmentRightInfo info = data.get(position);
        viewHolder.sort_right_item_title.setText(info.getSort_right_item_title());
        viewHolder.sort_right_item_title2.setText(info.getSort_right_item_title2());
        viewHolder.sort_right_item_imageText1.setText(info.getSort_right_item_imageText1());
        viewHolder.sort_right_item_imageText2.setText(info.getSort_right_item_imageText2());
        viewHolder.sort_right_item_imageText3.setText(info.getSort_right_item_imageText3());
        viewHolder.sort_right_item_imageText4.setText(info.getSort_right_item_imageText4());
        viewHolder.sort_right_item_imageText5.setText(info.getSort_right_item_imageText5());
        viewHolder.sort_right_item_imageText6.setText(info.getSort_right_item_imageText6());
        viewHolder.sort_right_item_imageText11.setText(info.getSort_right_item_imageText11());
        viewHolder.sort_right_item_imageText22.setText(info.getSort_right_item_imageText22());
        viewHolder.sort_right_item_imageText33.setText(info.getSort_right_item_imageText33());
        viewHolder.sort_right_item_imageText44.setText(info.getSort_right_item_imageText44());
        viewHolder.sort_right_item_imageText55.setText(info.getSort_right_item_imageText55());
        viewHolder.sort_right_item_imageText66.setText(info.getSort_right_item_imageText66());
        viewHolder.sort_right_item_imageText77.setText(info.getSort_right_item_imageText77());
        viewHolder.sort_right_item_imageText88.setText(info.getSort_right_item_imageText88());
        viewHolder.sort_right_item_imageText99.setText(info.getSort_right_item_imageText99());
        viewHolder.sort_right_itme_image2.setImageResource(info.getSort_right_itme_image2());
        viewHolder.sort_right_itme_image1.setImageResource(info.getSort_right_itme_image1());
        viewHolder.sort_right_itme_image3.setImageResource(info.getSort_right_itme_image3());
        viewHolder.sort_right_itme_image4.setImageResource(info.getSort_right_itme_image4());
        viewHolder.sort_right_itme_image5.setImageResource(info.getSort_right_itme_image5());
        viewHolder.sort_right_itme_image6.setImageResource(info.getSort_right_itme_image6());
        viewHolder.sort_right_itme_image11.setImageResource(info.getSort_right_itme_image11());
        viewHolder.sort_right_itme_image22.setImageResource(info.getSort_right_itme_image22());
        viewHolder.sort_right_itme_image33.setImageResource(info.getSort_right_itme_image33());
        viewHolder.sort_right_itme_image44.setImageResource(info.getSort_right_itme_image44());
        viewHolder.sort_right_itme_image55.setImageResource(info.getSort_right_itme_image55());
        viewHolder.sort_right_itme_image66.setImageResource(info.getSort_right_itme_image66());
        viewHolder.sort_right_itme_image77.setImageResource(info.getSort_right_itme_image77());
        viewHolder.sort_right_itme_image88.setImageResource(info.getSort_right_itme_image88());
        viewHolder.sort_right_itme_image99.setImageResource(info.getSort_right_itme_image99());
        //点击进行跳转  ico


        return convertView;
    }

    public class ViewHolder {
        public ImageView sort_right_itme_image1;
        public ImageView sort_right_itme_image2;
        public ImageView sort_right_itme_image3;
        public ImageView sort_right_itme_image4;
        public ImageView sort_right_itme_image5;
        public ImageView sort_right_itme_image6;
        public ImageView sort_right_itme_image11;
        public ImageView sort_right_itme_image22;
        public ImageView sort_right_itme_image33;
        public ImageView sort_right_itme_image44;
        public ImageView sort_right_itme_image55;
        public ImageView sort_right_itme_image66;
        public ImageView sort_right_itme_image77;
        public ImageView sort_right_itme_image88;
        public ImageView sort_right_itme_image99;
        public TextView sort_right_item_imageText1;
        public TextView sort_right_item_imageText2;
        public TextView sort_right_item_imageText3;
        public TextView sort_right_item_imageText4;
        public TextView sort_right_item_imageText5;
        public TextView sort_right_item_imageText6;
        public TextView sort_right_item_imageText11;
        public TextView sort_right_item_imageText22;
        public TextView sort_right_item_imageText33;
        public TextView sort_right_item_imageText44;
        public TextView sort_right_item_imageText55;
        public TextView sort_right_item_imageText66;
        public TextView sort_right_item_imageText77;
        public TextView sort_right_item_imageText88;
        public TextView sort_right_item_imageText99;
        public TextView sort_right_item_title;
        public TextView sort_right_item_title2;


    }
}
