package com.jiangkaiquan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhangshun.keep_in_good_health.R;

/**
 * Created by jkqme on 2016/3/14.
 */
public class Rcomend2 extends Activity {
    //底部button
    private TextView button[] = new TextView[3];
    private int buttonId[] = {R.id.my_friend_new_tx, R.id.my_friend_issue_group_tx, R.id.my_friend_car_tx};
    private TextView back;
    //子项标题
    private TextView child[] = new TextView[4];
    private TextView child1;
    private TextView child2;
    private TextView child3;
    //子项说明
    private TextView fruit[] = new TextView[5];
    private TextView fruit2;
    private TextView fruit2_1;
    private TextView fruit3;
    private TextView fruit4;
    //子项图片 
    private ImageView food[] = new ImageView[5];
    private ImageView food1;
    private ImageView food2;
    private ImageView food2_1;
    private ImageView food3;

    private int childId[] = {R.id.recomend_chirld_name_tx, R.id.recomend_chirld1_name_tx, R.id.recomend_chirld3_name_tx, R.id.recomend_chirld4_name_tx};
    private int fruitId[] = {R.id.recomend_friut_tx, R.id.recomend_friut1_tx, R.id.recomend_friut3_tx, R.id.recomend_friut3_1_tx, R.id.recomend_friut4_tx};
    private int foodId[] = {R.id.recomend2_food_img, R.id.recomend2_food1_img, R.id.recomend2_food3_img, R.id.recomend2_food3_1_img, R.id.recomend2_food4_img,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiang_recomend_2);
        for (int i = 0, j = 0; i < 4; i++, j++) {
            child[i] = (TextView) findViewById(childId[i]);
            fruit[j] = (TextView) findViewById(fruitId[j]);
            food[j] = (ImageView) findViewById(foodId[j]);
            //底部button实例化
          if (i < 3) {
                button[i] = (TextView) findViewById(buttonId[i]);
                button[i].setOnClickListener(listener);
            }
            //多余项实例
            if (i == 3) {
                j++;
                fruit[j] = (TextView) findViewById(fruitId[j]);
                food[j] = (ImageView) findViewById(foodId[j]);
            }
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.my_friend_new_tx:
                    break;
                case R.id.my_friend_issue_group_tx:
                    break;
                case R.id.my_friend_car_tx:
                    break;
            }
        }
    };
    private void display(){Toast.makeText(this,"可以使用",Toast.LENGTH_LONG).show();}
}
