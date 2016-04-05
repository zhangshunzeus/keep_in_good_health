package com.jiangkaiquan.aplication;

import java.util.ArrayList;

import android.graphics.Bitmap;

/**
 * 存用户信息的类
 * 
 * @author jkqme
 * 
 */
public class User {

	private String userName;
	private String userToken;
	private Bitmap userImg;
	private String phoneNum;
	private String password;

	private String token;

	private String weixinbind;// 微信
	private String xinlangBind;// 新浪
	private String alipayBind;// 阿里
	private String vchar;// 微信2
	private String qqNmber;// qq

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getQqNmber() {
		return qqNmber;
	}

	public void setQqNmber(String qqNmber) {
		this.qqNmber = qqNmber;
	}

	public String getVchar() {
		return vchar;
	}

	public void setVchar(String vchar) {
		this.vchar = vchar;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Bitmap getUserImg() {
		return userImg;
	}

	public void setUserImg(Bitmap userImg) {
		this.userImg = userImg;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	private String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWeixinbind() {
		return weixinbind;
	}

	public void setWeixinbind(String weixinbind) {
		this.weixinbind = weixinbind;
	}

	public String getXinlangBind() {
		return xinlangBind;
	}

	public void setXinlangBind(String xinlangBind) {
		this.xinlangBind = xinlangBind;
	}

	public String getAlipayBind() {
		return alipayBind;
	}

	public void setAlipayBind(String alipayBind) {
		this.alipayBind = alipayBind;
	}

	public ArrayList<UserGoods> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<UserGoods> goods) {
		this.goods = goods;
	}

	private ArrayList<UserGoods> goods = new ArrayList<User.UserGoods>();

	/**
	 * 存用户购物情况的类
	 * 
	 * @author jkqme
	 * 
	 */
	public class UserGoods {
	}

	/**
	 * 用户支付方式的类
	 * 
	 * @author jkqme
	 * 
	 */
	public class UserECard {
	}

	public class UserStor {
	}
}
