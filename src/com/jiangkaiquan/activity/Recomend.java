package com.jiangkaiquan.activity;

import com.zhangshun.activity.HomePageActivity;
import com.zhangshun.keep_in_good_health.R;
import com.zhangwenbin.activity.PersonalCenterLoginName;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.TextView;

/**
 * Created by jkqme on 2016/3/8.
 *
 */
public class Recomend extends Activity{
    @SuppressWarnings("unused")
	private ExpandableListView listView;
    TextView recomend_recomend_tx,recomend_bttom_1_tx,recomend_bttom_2_tx,recomend_bttom_3_tx;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recomend_indext_2);
        listView=new ExpandableListView(this);
        
        recomend_recomend_tx = (TextView) findViewById (R.id.recomend_recomend_tx);
        recomend_recomend_tx.setOnClickListener(click);
        
        recomend_bttom_1_tx = (TextView) findViewById (R.id.recomend_bttom_1_tx);
        recomend_bttom_1_tx.setOnClickListener(click);
        
        recomend_bttom_2_tx = (TextView) findViewById (R.id.recomend_bttom_2_tx);
        recomend_bttom_2_tx.setOnClickListener(click);
        
        recomend_bttom_3_tx = (TextView) findViewById (R.id.recomend_bttom_3_tx);
        recomend_bttom_3_tx.setOnClickListener(click);

    }
    
    OnClickListener click = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.recomend_recomend_tx:
				Intent intent = new Intent();
				intent.setClass(Recomend.this, HomePageActivity.class);
				startActivity(intent);
				break;
			case R.id.recomend_bttom_1_tx:
				Intent intent_homepage = new Intent();
				intent_homepage.setClass(Recomend.this, HomePageActivity.class);
				startActivity(intent_homepage);
				break;
			case R.id.recomend_bttom_2_tx:
				break;
			case R.id.recomend_bttom_3_tx:
				Intent intent_personalCenterLoginName = new Intent();
				intent_personalCenterLoginName.setClass(Recomend.this, PersonalCenterLoginName.class);
				startActivity(intent_personalCenterLoginName);
				break;
			default:
				break;
			}
		}
	};
    
}
