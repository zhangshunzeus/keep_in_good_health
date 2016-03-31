package com.ruanjiawei.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SaveToken {

	public static void saveToken(Context context, String token, String tel) {
		Log.i("saveToken", "token！" + token);
		Log.i("saveTel", tel);
		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"token", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("token", token);
		editor.commit();
		Log.i("saveToken", "token保存成功！");
	}

	/**
	 * 获取数据
	 * 
	 * @return
	 */
	public static String getData(Context context) {
		SharedPreferences preferences = context.getSharedPreferences("token",
				Context.MODE_PRIVATE);
		
		String data = preferences.getString("token", null);
		

		Log.i("getData", data);

		return data;
	}

}
