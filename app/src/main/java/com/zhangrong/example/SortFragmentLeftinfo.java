package com.zhangrong.example;

/**这是sort分类板块的，左边的fragment中的数据类
 * Created by zhang on 2016/3/10.
 */
public class SortFragmentLeftinfo {
    private String sort_left_text1;

    public SortFragmentLeftinfo() {


    }

    public String getSort_left_text1() {
        return sort_left_text1;
    }

    public void setSort_left_text1(String sort_left_text1) {
        this.sort_left_text1 = sort_left_text1;
    }

    @Override
    public String toString() {
        return "SortFragmentLeftinfo{" +
                "sort_left_text1='" + sort_left_text1 + '\'' +
                '}';
    }

    public SortFragmentLeftinfo(String sort_left_text1) {
        this.sort_left_text1 = sort_left_text1;
    }


}
