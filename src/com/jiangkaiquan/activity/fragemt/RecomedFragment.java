package com.jiangkaiquan.activity.fragemt;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;

import com.jiangkaiquan.activity.adapter.RecomendAdapter;

/**
 * Created by jkqme on 2016/3/11.
 */
public class RecomedFragment extends Fragment {
    private GridView gridView[] = new GridView[4];
    private int gid[] = {R.id.recomend1_fruit_gv, R.id.recomend_flish_gv, R.id.recomend_vgtable_gv, R.id.recomend_tea_gv};
    private int checkId[] = {R.id.recomend_chekmore_f_tx, R.id.recomend_chekmore_r_tx, R.id.recomend_chekmore_v_tx, R.id.recomend_chekmore_t_tx};
    private int foodTypId[] = {R.id.recomend1_fruit_tx, R.id.recomend1_flish_tx, R.id.recomend1_vgtable_tx, R.id.recomend1_tea_tx};
    private TextView text;
    private int curentDisplay = 4;
    private RecomendAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.jiang_recomend,null);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    private void loadVary() {
        for (int i = 0; i < gid.length; i++) {
            gridView[i] = (GridView) view.findViewById(gid[i]);
            text = (TextView) view.findViewById(checkId[i]);
            text.setOnClickListener(listener);
            text = (TextView) view.findViewById(foodTypId[i]);
            text.setOnClickListener(listener);
        }

    }
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.recomend_chekmore_f_tx:
                    break;
                case R.id.recomend_chekmore_r_tx:
                    break;
                case R.id.recomend_chekmore_v_tx:
                    break;
                case R.id.recomend_chekmore_t_tx:
                    break;

                case R.id.recomend1_fruit_tx:
                    disPlayGview(0);

                    break;
                case R.id.recomend1_flish_tx:
                    disPlayGview(1);

                    break;
                case R.id.recomend1_vgtable_tx:
                    disPlayGview(2);

                    break;
                case R.id.recomend1_tea_tx:
                    disPlayGview(3);

                    break;
            }
        }
    };
    /**
     * 显示各个列表i=0为水果
     *
     * @param i
     * @i=0为水果
     * @i=1为肉
     * @i=2菜
     * @i=3茶
     */
    private void disPlayGview(int i) {
        if (i == curentDisplay) {
            text = (TextView) view.findViewById(checkId[i]);
            //判断当前显示的列表是否被点击
            text.setVisibility(View.GONE);
            gridView[i].setVisibility(View.GONE);
            curentDisplay = 4;
            return;
        }
        for (int j = 0; j < 4; j++) {
            text = (TextView)view.findViewById(checkId[j]);
            if (j == i) {//显示被点击的项

                gridView[j].setVisibility(View.VISIBLE);
                text.setVisibility(View.VISIBLE);
                //当前显示的列表
                curentDisplay = i;
                //显示girdview
                getAdpter(i);
            } else {
                text.setVisibility(View.GONE);
                gridView[j].setVisibility(View.GONE);
            }
        }


    }
    /**
     * @i 列表项
     */
    private void getAdpter(int i) {
        ArrayList<Object> list = new ArrayList<Object>();
        adapter = new RecomendAdapter(list,getActivity());
        gridView[i].setAdapter(adapter);
    }
}
