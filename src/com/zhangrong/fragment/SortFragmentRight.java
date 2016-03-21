package com.zhangrong.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ruanjiawei.activity.MoreActivity;
import com.zhangrong.adapter.SortFragmentRightAdapter;
import com.zhangrong.example.SortFragmentRightInfo;
import com.zhangshun.activity.CommonDiseasesListForDetailsAcitivty;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;

import java.util.ArrayList;

/**
 * 这个fragment是，我的板块中的展示fragment，
 * 它加载的是我的板块布局
 *
 * @创建时间 2016-03-09
 */
public class SortFragmentRight extends Fragment {
    private ListView lv;
    private ArrayList<SortFragmentRightInfo> data = new ArrayList<SortFragmentRightInfo>();
    private SortFragmentRightInfo info;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sortfragment_radio1_right, container, false);
        lv = (ListView) view.findViewById(R.id.sort_right_listview);
        loadinivDataTwo();

        //设置item的点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                	Intent intent= new Intent(getActivity(),MoreActivity.class);
    				startActivity(intent);
                }
            }
        });
        SortFragmentRightAdapter adapter = new SortFragmentRightAdapter(getActivity(), data);

//        Log.i("jjj", "执行到了SortRight的fragment中" + info.toString());

        lv.setAdapter(adapter);


        return view;
    }

    private void loadinivDataTwo() {
        for (int i = 1; i < 2; i++) {

            info = new SortFragmentRightInfo();
            info.setSort_right_item_imageText1("选择恐惧症...");
            info.setSort_right_item_imageText11("汤臣倍健R蛋白粉");
            info.setSort_right_item_imageText2("水果也分四...");
            info.setSort_right_item_imageText22("善存R佳维片");
            info.setSort_right_item_imageText3("春季美妆注...");
            info.setSort_right_item_imageText33("钙尔奇牌添佳片");
            info.setSort_right_item_imageText4("不可隔夜吃...");
            info.setSort_right_item_imageText44("康比特牌减肥胶囊");
            info.setSort_right_item_imageText5("如何挑选婴...");
            info.setSort_right_item_imageText55("无极限 灵芝皇胶囊");
            info.setSort_right_item_imageText6("你缺那种维...");
            info.setSort_right_item_imageText66("国珍牌松花粉");
            info.setSort_right_item_imageText77("三列奖抗疲劳");
            info.setSort_right_item_imageText88("绿A天然螺旋");
            info.setSort_right_item_imageText99("中农 破壁灵芝孢子粉");
            info.setSort_right_item_title("为您推荐");
            info.setSort_right_item_title2("保健人生");
            info.setSort_right_itme_image1(R.drawable.sort_right_itme_image1);
            info.setSort_right_itme_image11(R.drawable.sort_right_itme_image11);
            info.setSort_right_itme_image2(R.drawable.sort_right_itme_image2);
            info.setSort_right_itme_image22(R.drawable.sort_right_itme_image22);
            info.setSort_right_itme_image3(R.drawable.sort_right_itme_image3);
            info.setSort_right_itme_image33(R.drawable.sort_right_itme_image33);
            info.setSort_right_itme_image4(R.drawable.sort_right_itme_image4);
            info.setSort_right_itme_image44(R.drawable.sort_right_itme_image44);
            info.setSort_right_itme_image5(R.drawable.sort_right_itme_image5);
            info.setSort_right_itme_image55(R.drawable.sort_right_itme_image55);
            info.setSort_right_itme_image6(R.drawable.sort_right_itme_image6);
            info.setSort_right_itme_image66(R.drawable.sort_right_itme_image66);
            info.setSort_right_itme_image77(R.drawable.sort_right_itme_image77);
            info.setSort_right_itme_image88(R.drawable.sort_right_itme_image88);
            info.setSort_right_itme_image99(R.drawable.sort_right_itme_image99);
            Log.i("jjj", info.toString());
            data.add(info);
        }
    }


}





