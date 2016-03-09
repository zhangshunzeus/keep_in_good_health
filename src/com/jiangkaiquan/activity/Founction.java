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
public class Founction extends Activity {
    private ImageView back;
    private ImageView title_img;
    private TextView title1;
    private TextView title2;
    private TextView context1;

    private TextView context2;
    private ImageView client_img;
    private TextView comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiang_function);
    }

    private void loadWeidegt() {
        back = (ImageView) findViewById(R.id.function_back_img);
        back.setOnClickListener(listener);
        title_img = (ImageView) findViewById(R.id.function_tile_img);
        title_img.setOnClickListener(listener);
        client_img = (ImageView) findViewById(R.id.function_client_img);
        client_img.setOnClickListener(listener);


        title1 = (TextView) findViewById(R.id.funcion_title_tx);
        title2 = (TextView) findViewById(R.id.funcion_title2_tx);
       context1 = (TextView) findViewById(R.id.funcion_context1_tx);
        context2 = (TextView) findViewById(R.id.funcion_context2_tx);

    }
    private View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.function_back_img:
                    break;
                case R.id.function_tile_img:
                    break;
                case R.id.function_client_img:
                    break;
            }
        }
    };
}
