package com.zhangwenbin.activity;
//创建了一个接口，用于httpUtiol的回调
public interface HttpCallBackInterface {
	
	void onFinish(String response);
	void onError(Exception e);

}
