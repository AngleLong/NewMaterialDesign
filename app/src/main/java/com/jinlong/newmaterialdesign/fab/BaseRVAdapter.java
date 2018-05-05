package com.jinlong.newmaterialdesign.fab;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jinlong.newmaterialdesign.R;

/**
 * 作者: 贺金龙 QQ:753355530
 * 项目名称: NewMaterialDesign
 * 类名称:com.jinlong.newmaterialdesign.fab
 * 类描述:
 * 创建时间: 2018/5/5 9:48
 * 修改内容:
 * 修改时间:
 * 修改描述:
 */
public class BaseRVAdapter extends RecyclerView.Adapter<BaseRVAdapter.Holder> {

    @Override
    public BaseRVAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseRVAdapter.Holder holder, int position) {
        holder.tv.setText("条目是第" + position + "条");
    }

    @Override
    public int getItemCount() {
        return 50;
    }


    class Holder extends RecyclerView.ViewHolder {
        private TextView tv;

        public Holder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
