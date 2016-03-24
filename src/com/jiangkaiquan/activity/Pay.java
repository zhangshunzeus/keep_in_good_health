package com.jiangkaiquan.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.zhangshun.keep_in_good_health.R;

/**
 * Created by jkqme on 2016/3/15.
 */
public class Pay extends Activity {
    private RelativeLayout relativeLayout;
    private int reId[] = {R.id.pay_aliy_rl, R.id.pay_tx_rl, R.id.pay_ebank_rl};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jiang_pay);
        for (int i : reId) {
            relativeLayout = (RelativeLayout) findViewById(i);
            relativeLayout.setOnClickListener(listener);
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.pay_aliy_rl:
                    break;
                case R.id.pay_tx_rl:
                    break;
                case R.id.pay_ebank_rl:
                    break;
            }
        }
    };
}
