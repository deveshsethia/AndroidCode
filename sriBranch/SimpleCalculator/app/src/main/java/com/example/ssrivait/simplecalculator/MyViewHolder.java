package com.example.ssrivait.simplecalculator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    Button button;
    Itemclick itemclick;

    public MyViewHolder(View itemView, Itemclick itemclick){
        super(itemView);
        button=itemView.findViewById(R.id.textinfo);
        button.setOnClickListener(this);
        this.itemclick=itemclick;
    }
    @Override
    public void onClick(View v) {
        if(itemclick!=null){
            itemclick.onItemClick(v,getAdapterPosition());

        }

    }
}
