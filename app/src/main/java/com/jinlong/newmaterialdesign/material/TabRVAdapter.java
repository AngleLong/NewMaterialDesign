package com.jinlong.newmaterialdesign.material;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jinlong.newmaterialdesign.R;

public class TabRVAdapter extends RecyclerView.Adapter <TabRVAdapter.TabHolder>{


    @NonNull
    @Override
    public TabHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tab,parent,false);
        return new TabHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TabHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    class TabHolder extends RecyclerView.ViewHolder{
        public TabHolder(View itemView) {
            super(itemView);
        }
    }
}
