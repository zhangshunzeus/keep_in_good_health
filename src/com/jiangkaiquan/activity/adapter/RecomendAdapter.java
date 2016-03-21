package com.jiangkaiquan.activity.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.zhangshun.keep_in_good_health.R;
import java.util.ArrayList;

/**
 * Created by jkqme on 2016/3/10.
 *
 * Recomend.class 和Myfriend1公用此adapter
 */
public class RecomendAdapter extends BaseAdapter {
  private ArrayList<Object>list;
    private Context context;
    private LayoutInflater inflater;

    RecomendAdapter(){}
    public RecomendAdapter(ArrayList<Object>list,
          Context context
           ){
        this.list=list;
        this.context=context;
       inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Holder holder;
      if(view==null){
          view=inflater.inflate(R.layout.recomend_children,null);
          holder=new Holder();
          holder.img=(ImageView)view.findViewById(R.id.recomend_children_img);
          holder.text=(TextView)view.findViewById(R.id.recomend_children_tx);
          holder.text.setText(i+"");
          holder.img.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_launcher));
          view.setTag(holder);
          Log.i("getView","adpter");
      }else {
          holder=(Holder)view.getTag();
          holder.text.setText("fdsafadsfadsfasd");
          holder.img.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_launcher));
      }

        return view;
    }
   class Holder{
       ImageView img;
       TextView text;
   }
}
