package com.zhangrong.example;




import android.widget.ImageView;

/**
 * Created by zhang on 2016/3/17.
 */
public class ListPayInfo {
    private int  pu_er_tea;
    private String the_shopping_title;
    private String the_shopping_content;
    private int the_shopping_number;
    private Double The_price;
    private boolean check;

    @Override
    public String toString() {
        return "ListPayInfo{" +
                "pu_er_tea=" + pu_er_tea +
                ", the_shopping_title='" + the_shopping_title + '\'' +
                ", the_shopping_content='" + the_shopping_content + '\'' +
                ", the_shopping_number='" + the_shopping_number + '\'' +
                ", The_price='" + The_price + '\'' +
                ", check=" + check +
                '}';
    }



    public int getPu_er_tea() {
        return pu_er_tea;
    }

    public void setPu_er_tea(int pu_er_tea) {
        this.pu_er_tea = pu_er_tea;
    }

    public String getThe_shopping_title() {
        return the_shopping_title;
    }

    public void setThe_shopping_title(String the_shopping_title) {
        this.the_shopping_title = the_shopping_title;
    }

    public String getThe_shopping_content() {
        return the_shopping_content;
    }

    public void setThe_shopping_content(String the_shopping_content) {
        this.the_shopping_content = the_shopping_content;
    }

    public int getThe_shopping_number() {
        return the_shopping_number;
    }

    public void setThe_shopping_number(int the_shopping_number) {
        this.the_shopping_number = the_shopping_number;
    }

    public Double getThe_price() {
        return The_price;
    }

    public void setThe_price(double the_price) {
        The_price = the_price;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }



	public String getItem_title() {
		// TODO Auto-generated method stub
		return null;
	}


}
