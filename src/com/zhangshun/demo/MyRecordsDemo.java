package com.zhangshun.demo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class MyRecordsDemo {
	private Bitmap image;
	private String my_records_content;
	private int my_records_change_receiving;
	private String my_records_shop_name;
	private String my_records_list_goodsstates;
	private String my_records_shop_type;
	private String my_records_shop_number;
	private String my_records_shop_money;
	public boolean checked;


	public String getMy_records_content() {
		return my_records_content;
	}

	public void setMy_records_content(String my_records_content) {
		this.my_records_content = my_records_content;
	} 
 
	public String getMy_records_shop_name() {
		return my_records_shop_name;
	}

	public void setMy_records_shop_name(String my_records_shop_name) {
		this.my_records_shop_name = my_records_shop_name;
	}

	public String getMy_records_shop_type() {
		return my_records_shop_type;
	}

	public void setMy_records_shop_type(String my_records_shop_type) {
		this.my_records_shop_type = my_records_shop_type;
	}

	public String getMy_records_shop_number() {
		return my_records_shop_number;
	}

	public void setMy_records_shop_number(String my_records_shop_number) {
		this.my_records_shop_number = my_records_shop_number;
	}

	public String getMy_records_shop_money() {
		return my_records_shop_money;
	}

	public void setMy_records_shop_money(String my_records_shop_money) {
		this.my_records_shop_money = my_records_shop_money;
	}

	public int getMy_records_change_receiving() {
		return my_records_change_receiving;
	}

	public void setMy_records_change_receiving(int my_records_change_receiving) {
		this.my_records_change_receiving = my_records_change_receiving;
	}

	public String getMy_records_list_goodsstates() {
		return my_records_list_goodsstates;
	}

	public void setMy_records_list_goodsstates(
			String my_records_list_goodsstates) {
		this.my_records_list_goodsstates = my_records_list_goodsstates;
	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap bitmap) {
		this.image = bitmap;
	}

}

