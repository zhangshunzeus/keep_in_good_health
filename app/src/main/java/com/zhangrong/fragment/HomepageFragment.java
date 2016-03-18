package com.zhangrong.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangshun.keep_in_good_health.R;

/**这个类是 主页板块的主的fragment
 *  它加载的主页板块的布局
 * @创建时间   2016-03-10
 */
public class HomepageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.homepage_fragment,container,false);
        return view;
    }
}
