package com.zhangrong.example;

/**这个类，是加载点击菜品的  listview的对象数据类 ，是MealName的数据类
 * @编者   zhangrong
 */
public class MealnameInfo_b {
    public int meal_name_show_image;
    public int food_iamge_one;
    public String food_text_one;
    public int food_iamge_two;
    public String food_text_two;
    public int food_iamge_three;
    public String food_text_three;
    public String meal_name_Liao_text;
    public String meal_name_dosing_text;
    public String  meal_name_practice_text;

    public MealnameInfo_b(){

    }

    public MealnameInfo_b(int meal_name_show_image, int food_iamge_one, String food_text_one, int food_iamge_two, String food_text_two, int food_iamge_three, String food_text_three, String meal_name_Liao_text, String meal_name_dosing_text, String meal_name_practice_text) {
        this.meal_name_show_image = meal_name_show_image;
        this.food_iamge_one = food_iamge_one;
        this.food_text_one = food_text_one;
        this.food_iamge_two = food_iamge_two;
        this.food_text_two = food_text_two;
        this.food_iamge_three = food_iamge_three;
        this.food_text_three = food_text_three;
        this.meal_name_Liao_text = meal_name_Liao_text;
        this.meal_name_dosing_text = meal_name_dosing_text;
        this.meal_name_practice_text = meal_name_practice_text;
    }


    @Override
    public String toString() {
        return "MealnameInfo{" +
                "meal_name_show_image=" + meal_name_show_image +
                ", food_iamge_one=" + food_iamge_one +
                ", food_text_one='" + food_text_one + '\'' +
                ", food_iamge_two=" + food_iamge_two +
                ", food_text_two='" + food_text_two + '\'' +
                ", food_iamge_three=" + food_iamge_three +
                ", food_text_three='" + food_text_three + '\'' +
                ", meal_name_Liao_text='" + meal_name_Liao_text + '\'' +
                ", meal_name_dosing_text='" + meal_name_dosing_text + '\'' +
                ", meal_name_practice_text='" + meal_name_practice_text + '\'' +
                '}';
    }



    public int getMeal_name_show_image() {
        return meal_name_show_image;
    }

    public void setMeal_name_show_image(int meal_name_show_image) {
        this.meal_name_show_image = meal_name_show_image;
    }

    public int getFood_iamge_one() {
        return food_iamge_one;
    }

    public void setFood_iamge_one(int food_iamge_one) {
        this.food_iamge_one = food_iamge_one;
    }

    public String getFood_text_one() {
        return food_text_one;
    }

    public void setFood_text_one(String food_text_one) {
        this.food_text_one = food_text_one;
    }

    public int getFood_iamge_two() {
        return food_iamge_two;
    }

    public void setFood_iamge_two(int food_iamge_two) {
        this.food_iamge_two = food_iamge_two;
    }

    public String getFood_text_two() {
        return food_text_two;
    }

    public void setFood_text_two(String food_text_two) {
        this.food_text_two = food_text_two;
    }

    public int getFood_iamge_three() {
        return food_iamge_three;
    }

    public void setFood_iamge_three(int food_iamge_three) {
        this.food_iamge_three = food_iamge_three;
    }

    public String getFood_text_three() {
        return food_text_three;
    }

    public void setFood_text_three(String food_text_three) {
        this.food_text_three = food_text_three;
    }

    public String getMeal_name_Liao_text() {
        return meal_name_Liao_text;
    }

    public void setMeal_name_Liao_text(String meal_name_Liao_text) {
        this.meal_name_Liao_text = meal_name_Liao_text;
    }

    public String getMeal_name_dosing_text() {
        return meal_name_dosing_text;
    }

    public void setMeal_name_dosing_text(String meal_name_dosing_text) {
        this.meal_name_dosing_text = meal_name_dosing_text;
    }

    public String getMeal_name_practice_text() {
        return meal_name_practice_text;
    }

    public void setMeal_name_practice_text(String meal_name_practice_text) {
        this.meal_name_practice_text = meal_name_practice_text;
    }



}
