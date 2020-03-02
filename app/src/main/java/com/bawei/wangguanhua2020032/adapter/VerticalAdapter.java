package com.bawei.wangguanhua2020032.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangguanhua2020032.R;
import com.bawei.wangguanhua2020032.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 */
public class VerticalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.VerticalListDataBean> list;
    public IClick mClick;
    public VerticalAdapter(Context context, List<Bean.DataBean.VerticalListDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //加载布局
        View view = View.inflate(context, R.layout.item2, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        Bean.DataBean.VerticalListDataBean bean = list.get(position);
        String imageurl = bean.getImageurl();
        String price = bean.getPrice();
        String title = bean.getTitle();
        ((ViewHolder)holder).tt.setText(title);
        ((ViewHolder)holder).tv.setText(price);
        //加载图片
        //使用Glide完成网络图片加载，并配置占位图、错误图
        Glide.with(context)
                .load(imageurl)
                .error(R.mipmap.jd)
                .placeholder(R.mipmap.ic_launcher)
                .into((((ViewHolder) holder)).img);
        //设置点击事件
        ((ViewHolder)holder).tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClick.onClick(position);
            }
        });
    }
    //创建点击事件方法
    public void onClick(IClick iClick){
        mClick=iClick;
    }
    //创建点击事件接口
    public interface IClick{
        void onClick(int position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;
        private final TextView tt;
        private final TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            //找控件
            img = itemView.findViewById(R.id.two_iv);
            tt = itemView.findViewById(R.id.two_tt);
            tv = itemView.findViewById(R.id.two_tv);
        }
    }
}
