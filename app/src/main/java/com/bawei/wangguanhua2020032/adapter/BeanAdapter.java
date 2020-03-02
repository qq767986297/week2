package com.bawei.wangguanhua2020032.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.wangguanhua2020032.R;
import com.bawei.wangguanhua2020032.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Time: 2020/3/2
 * Author: 王冠华
 * Description:
 */
public class BeanAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Bean.DataBean.HorizontalListDataBean> list;

    public BeanAdapter(Context context, List<Bean.DataBean.HorizontalListDataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item1, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //获取对应角标
        Bean.DataBean.HorizontalListDataBean bean = list.get(position);
        String imageurl = bean.getImageurl();
        //加载图片
        //使用Glide完成网络图片加载，并配置占位图、错误图
        Glide.with(context)
                .load(imageurl)
                .error(R.mipmap.jd)
                .placeholder(R.mipmap.ic_launcher)
                .into(((ViewHolder)holder).img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        private final ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            //找控件
            img = itemView.findViewById(R.id.one_iv);
        }
    }
}
