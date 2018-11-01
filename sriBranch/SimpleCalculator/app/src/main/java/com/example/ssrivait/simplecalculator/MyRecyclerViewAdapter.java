package com.example.ssrivait.simplecalculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater layoutInflater;
    private String[] data;
    private Itemclick itemclick;

    public MyRecyclerViewAdapter(Context context, String[] data){
        this.layoutInflater=LayoutInflater.from(context);
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view=layoutInflater.inflate(R.layout.recycler_view,viewGroup, false);
        return new MyViewHolder(view,itemclick);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
    myViewHolder.button.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public void setClickListener(Itemclick itemclick){
        this.itemclick=itemclick;
    }

     public String getData(int Position){
        return data[Position];
    }


}
