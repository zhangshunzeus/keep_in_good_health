package com.zhangrong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.zhangrong.adapter.SortFragmentRightAdapter;
import com.zhangrong.example.SortFragmentRightInfo;
import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

/**
 * 这个fragment是，我的板块中的展示fragment，
 * 它加载的是我的板块布局
 *
 * @创建时间 2016-03-09
 */
public class SortFragmentRight extends Fragment {
    private ListView lv;
    private ArrayList<SortFragmentRightInfo> data=new ArrayList<SortFragmentRightInfo>();
    private String[] text1 = new String[100];
    private String[] text2 = new String[100];
    private String[] text3 = new String[100];
    private String[] text4 = new String[100];
    private String[] text5 = new String[100];
    private String[] text6 = new String[100];
    private String[] title = new String[100];
    private SortFragmentRightInfo info;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sortfragment_right, container, false);
        lv = (ListView) view.findViewById(R.id.sort_right_listview);
        SortFragmentRightAdapter adapter = new SortFragmentRightAdapter(getActivity(), data);

//        Log.i("jjj", "执行到了SortRight的fragment中" + info.toString());
        loadinivData();
        lv.setAdapter(adapter);


        return view;
    }

    private void loadinivData() {
        int[] imageData = {R.drawable.mealname_back_icon, R.drawable.rub_course_me_not_selected_bg, R.drawable.ssdk_oks_logo_foursquare,
                R.drawable.collection_big_non_sel, R.drawable.collection_big_sel, R.drawable.food_icon,
                R.drawable.collection_big_non_sel, R.drawable.collection_big_sel, R.drawable.food_icon,
                R.drawable.rub_course_home_page_not_selected_bg, R.drawable.ssdk_oks_logo_foursquare, R.drawable.ssdk_oks_logo_sohusuishenkan};
        for (int i = 0; i < 50; i++) {
            text1[i] = "你不要在熬夜了" + i;
            text2[i] = "贵在坚持" + i;
            text3[i] = "梦想就在前方" + i;
            text4[i] = "我喜欢做动车" + i;
            text5[i] = "李小龙是我的偶像" + i;
            text6[i] = "陈奕迅的歌真的很好听额" + i;
            title[i] = "保健人生" + i;
        }
        for (int i = 0; i < 18; i++) {
            info = new SortFragmentRightInfo();
            info.setSort_right_item_imageText1( "你不要在熬夜了" + i);
            info.setSort_right_item_imageText1("贵在坚持" + i);
            info.setSort_right_item_imageText1("梦想就在前方" + i);
            info.setSort_right_item_imageText1("我喜欢做动车" + i);
            info.setSort_right_item_imageText1("李小龙是我的偶像" + i);
            info.setSort_right_item_imageText1("陈奕迅的歌真的很好听额");
            info.setSort_right_item_title("保健人生" + i);
//            info.setSort_right_itme_image1(imageData[i]);
//            info.setSort_right_itme_image2(imageData[i]);
//            info.setSort_right_itme_image3(imageData[i]);
//            info.setSort_right_itme_image4(imageData[i]);
//            info.setSort_right_itme_image5(imageData[i]);
//            info.setSort_right_itme_image6(imageData[i]);
            Log.i("jjj", info.toString());
           data.add(info);


        }



    }

}
