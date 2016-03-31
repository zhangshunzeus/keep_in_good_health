package com.zhangrong.adapter;





import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import com.zhangrong.activity.MainActivity;
import com.zhangrong.activity.TheShopingCartActivityGG;
import com.zhangrong.example.ListPayInfo;
import com.zhangshun.keep_in_good_health.R;

/**
 * Created by zhang on 2016/3/17.
 */
public class ListPayAdapter extends BaseAdapter {
    private  Context context;
    int index=0;
   //String[] shopName=new String[3];
   String shopName="";
    private  Double  sum=0.00;
     int p;
    TextView text1;
    public   ArrayList<Boolean> isSelected;//判读是否选中

    private  ArrayList<ListPayInfo> data;
    public ListPayAdapter(Context context,ArrayList<ListPayInfo> data){
        this.context=context;
        this.data=data;
        isSelected=new ArrayList<Boolean>();
        // 初始化数据
        initDate();
    }



    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.the_shopping_cart_list_item,null);
            viewHolder.pu_er_tea= (ImageView) convertView.findViewById(R.id.pu_er_tea);
            viewHolder.the_shopping_title= (TextView) convertView.findViewById(R.id.the_shopping_title);
            viewHolder.the_shopping_number= (TextView) convertView.findViewById(R.id.the_shopping_number);
          viewHolder.the_shopping_content= (TextView) convertView.findViewById(R.id.the_shopping_content);
          viewHolder.Future_generations_box= (CheckBox) convertView.findViewById(R.id.Future_generations);
          viewHolder.The_price=(TextView)convertView.findViewById(R.id.The_price);
            p = position;
            // 为view设置标签
            // final boolean ischecked = holder.check_goods.isChecked();
            viewHolder.Future_generations_box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CheckBox cb = (CheckBox) v;//把点击对象拿到
                    isSelected.set(p, cb.isChecked());//进行判读，设置
                        /*
                         * holder.check_goods.toggle(); isSelected.put(position,
                         * holder.check_goods.isChecked());
                         */
                    Log.i("pay","ID:"+v.getId());
                    if(viewHolder.Future_generations_box.isChecked()) {
                        TheShopingCartActivityGG activity = (TheShopingCartActivityGG) context;
                        View view = activity.getLayoutInflater().inflate(R.layout.theshopingcat_activity, null);
                        text1 = (TextView) view.findViewById(R.id.text1);
                        text1.setText("合计：￥" + data.get(position).getThe_price());
                        Log.i("pay", "" + text1.getText());
                        sum=((sum*100)+(data.get(position).getThe_price()*100))/100;
//                        shopName[index]=data.get(position).getThe_shopping_title();
//                        builder=builder.append(" "+data.get(position).getThe_shopping_title());
                        shopName=shopName+".."+data.get(position).getThe_shopping_title();
                        index=index+1;





                    }else{
//                        shopName[index]="";
                     sum=((sum*100)-(data.get(position).getThe_price()*100))/100;
                     index=index-1;
                        shopName=shopName.replaceAll(".."+data.get(position).getThe_shopping_title(),"");





                    }
//                    for(int i=0;i<shopName.length;i++){
//
//                        buffer.append(shopName[i]);
//                    }
//                    Log.i("pay","Adatper中的数组"+buffer.toString());
                    Log.i("pay","ADAPTER字符串"+shopName);
                    getBoxPices(sum, index, shopName);

                }

            });
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();

        }
        //进行控制
        ListPayInfo info=data.get(position);
        viewHolder.pu_er_tea.setImageResource(info.getPu_er_tea());
        viewHolder.the_shopping_title.setText(info.getThe_shopping_title());
        viewHolder.the_shopping_number.setText(""+info.getThe_shopping_number());
        viewHolder.the_shopping_content.setText(info.getThe_shopping_content());
        viewHolder.The_price.setText("￥" + Double.toString(info.getThe_price()));
        viewHolder.Future_generations_box.setChecked(isSelected.get(position));
        //

        return convertView;

    }
    // 初始化isSelected的数据
    private void initDate() {
        for (int i = 0; i < data.size(); i++) {
            isSelected.add(i, false);
        }
    }
    public ArrayList<ListPayInfo> getData() {
        return data;
    }

    public void setData(ArrayList<ListPayInfo> data) {
        this.data = data;
    }
    public ArrayList<Boolean> getIsSelected() {
        return isSelected;
    }

    public void setIsSelected(ArrayList<Boolean> isSelected) {
        this.isSelected = isSelected;
    }
    private void getBoxPices(Double i,int index,String shoppName){
        Intent intent=new Intent();
        Log.i("pay","boxpices:"+i);
        intent.putExtra("pices", i);
        intent.putExtra("index",index);
        intent.putExtra("shopName",shoppName);
        intent.setAction("sss");
        context.sendBroadcast(intent);//发送广播


    }

    public static class ViewHolder{
        private ImageView pu_er_tea;
        private TextView  the_shopping_title;
        private TextView  the_shopping_content;
        private TextView  the_shopping_number;
        private TextView  The_price;
        private CheckBox  Future_generations_box;


    }
}
