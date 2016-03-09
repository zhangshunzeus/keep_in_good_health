package com.jiangkaiquan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

/**
 * Created by jkqme on 2016/3/9.
 */
public class Produce_detail extends Activity {

    private ImageView back;
    private TextView title;
    private ImageView img;
    private ImageView bycar;
    private TextView discrible;
    private TextView disCont;
    private TextView disCont2;
    private TextView promiss;

    //private int id[]={R.id.};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.jiang_produce_detail);
    }

    private void loadWedige() {
        back = (ImageView) findViewById(R.id.produce_detail_back_img);
        back.setOnClickListener(listener);
        img = (ImageView) findViewById(R.id.produce_detail_img);
        back.setOnClickListener(listener);
        bycar = (ImageView) findViewById(R.id.produce_detail_bycar_img);
        back.setOnClickListener(listener);
        title = (TextView) findViewById(R.id.produce_detail_title_tx);
        back.setOnClickListener(listener);
        discrible = (TextView) findViewById(R.id.produce_detail_function_tx);
        back.setOnClickListener(listener);
        disCont = (TextView) findViewById(R.id.produce_detail_discont_tx);
        back.setOnClickListener(listener);
        disCont2 = (TextView) findViewById(R.id.produce_detail_discont_2_tx);
        back.setOnClickListener(listener);
        promiss = (TextView) findViewById(R.id.produce_detail_promiss_tx);
        back.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.produce_detail_back_img:
                    break;
                case R.id.produce_detail_img:
                    break;
                case R.id.produce_detail_bycar_img:
                    break;
                case R.id.produce_detail_title_tx:
                    break;
                case R.id.produce_detail_function_tx:
                    break;
                case R.id.produce_detail_discont_tx:
                    break;
                case R.id.produce_detail_discont_2_tx:
                    break;
                case R.id.produce_detail_promiss_tx:
                    break;

            }
        }
    };
}
