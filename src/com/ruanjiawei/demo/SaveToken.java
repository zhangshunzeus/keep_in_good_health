package com.ruanjiawei.demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class SaveToken {

	public static void saveToken(Context context, String token) {
		Log.i("saveToken", "token！" + token);

		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"token", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("token", token);
		editor.commit();
		Log.i("saveToken", "token保存成功！");
	}
	
	public static void saveTel(Context context, String tel) {
		Log.i("saveTel", "tel！" + tel);

		SharedPreferences sharedPreferences = context.getSharedPreferences(
				"tel", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString("tel", tel);
		editor.commit();
		Log.i("savetel", "tel保存成功！");
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
	
	
	
	public static String getTels(Context context) {
		SharedPreferences preferences = context.getSharedPreferences("tel",
				Context.MODE_PRIVATE);

		String data = preferences.getString("tel", null);

		Log.i("getData", data);

		return data;
	}
	/**
	 * 删除token
	 * 
	 * @param context
	 */
	public static void deleteData(Context context) {
		SharedPreferences preferences = context.getSharedPreferences("token", Context.MODE_PRIVATE);
		// 删除token
		preferences.edit().clear().commit();
		Log.i("deleteData", "token删除成功！");
	}
	
	/**
	 * 判断账号是否登录
	 * 
	 * @return
	 */
	public static boolean checkLogin(Context context) {
		String tok = SaveToken.getData(context);
		if (tok != null && !tok.equals("")) {
	//		username = tok.split(",")[1];
			return true;
		}
		Toast.makeText(context, "请先登录！", Toast.LENGTH_SHORT).show();
		return false;
	}
	
	/**
	 * 获取存储在本地的tel
	 * @param context
	 * @return
	 */
	public static String getTel(Context context){
		if(checkLogin(context)){
			String tok = SaveToken.getData(context);
			return tok.split(",")[1];
		}else{
			return "未登录";
		}
	}
	
	/**
	 * 获取存储在本地的token
	 * @param context
	 * @return
	 */
	public static String getToken(Context context){
		if(checkLogin(context)){
			String tok = SaveToken.getData(context);
			return tok.split(",")[0];
		}else{
			return "未登录";
		}
	}


}
