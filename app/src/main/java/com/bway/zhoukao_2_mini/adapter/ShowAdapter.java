package com.bway.zhoukao_2_mini.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bway.zhoukao_2_mini.R;
import com.bway.zhoukao_2_mini.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by 择木 on 2018/12/8.
 */

public class ShowAdapter extends RecyclerView.Adapter<ShowAdapter.ViewHolder>{
    private Context context;
    private List<ShowBean.NewslistBean> list;

    public ShowAdapter(Context context, List<ShowBean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=View.inflate(context,R.layout.show_item,null);
        ViewHolder viewHolder=new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final SimpleDraweeView sdvShow;

        public ViewHolder(View itemView) {
            super(itemView);
            sdvShow = itemView.findViewById(R.id.sdv_show);
            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
