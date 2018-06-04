package com.teaching.android.miprimeraapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.teaching.android.miprimeraapp.R;
import com.teaching.android.miprimeraapp.MyViewHolder;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
    private String[] dataSet;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_item,parent,false);
        return new MyViewHolder(view);
    }

    public MyRecyclerViewAdapter(String[] dataSet){
        this.dataSet= dataSet;
    }

    @Override
    public int getItemCount() {
        return dataSet != null ? dataSet.length : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder)holder).Bind(dataSet[position]);
    }

}
