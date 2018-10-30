package com.example.bseeram.calculator.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bseeram.calculator.CustomListener;
import com.example.bseeram.calculator.MainActivity;
import com.example.bseeram.calculator.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    @NonNull
    List<String> list = new ArrayList<>();
    CustomListener customListener;

    public MyAdapter(CustomListener customListener, @NonNull List<String> list) {
        this.customListener = customListener;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_layout, null);
        return new MyHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder viewHolder, int i) {
        viewHolder.button.setText(list.get(i));
        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button clickedButton = v.findViewById(R.id.button);
                String clickValue = clickedButton.getText().toString();
                customListener.onClick(clickValue);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        Button button;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.button);
        }
    }
}
