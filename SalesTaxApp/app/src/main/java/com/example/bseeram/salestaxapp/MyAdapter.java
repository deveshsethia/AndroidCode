package com.example.bseeram.salestaxapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    List<Item> list;

    public MyAdapter(List list) {
        this.list=list;

    }

    @NonNull
    @Override
    public MyAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_text,null);
       return new Myholder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Myholder viewHolder, int i) {
               viewHolder.textView.setText(list.get(i).getItemName());
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    protected class Myholder extends RecyclerView.ViewHolder {
        TextView textView;
        public Myholder(@NonNull View itemView) {
            super(itemView);
             textView=itemView.findViewById(R.id.customtext);

        }
    }
}
