package com.jiangkaiquan.aplication;

import android.app.Application;

/**
 * 存放了全局的user 变量
 * 
 * @author jkqme
 * 
 */
public class MyApplaication extends Application {
	public User user = new User();

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
}
