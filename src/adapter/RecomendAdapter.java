package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangshun.keep_in_good_health.R;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by jkqme on 2016/3/10.
 */
public class RecomendAdapter extends BaseAdapter {
  private ArrayList<Object>list;
    private Context context;
    private LayoutInflater inflater;
    private Holder holder;
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
        return 9;
    }

    @Override
    public Object getItem(int i) {
        return 1;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
      if(view==null){
          view=inflater.inflate(R.layout.recomend_children,null);
          holder=new Holder();
          holder.img=(ImageView)view.findViewById(R.id.recomend_children_img);
          holder.text=(TextView)view.findViewById(R.id.recomend_children_tx);
          holder.text.setText(i+"");
          holder.img.setImageDrawable(view.getResources().getDrawable(R.drawable.ic_launcher));
          view.setTag(holder);
      }else {
          holder=(Holder)view.getTag();
      }

        return view;
    }
   class Holder{
       ImageView img;
       TextView text;
   }
}
