package com.example.sdevesh.calculator.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sdevesh.calculator.Calculator_Logic;

import com.example.sdevesh.calculator.MainActivity;
import com.example.sdevesh.calculator.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {


    @NonNull

    private String num[];
    public String button="";
    private Customlistener customlistener;
    TextView textview;
    Calculator_Logic calculatorLogic=new Calculator_Logic();;

    public MyAdapter(Customlistener customlistener, @NonNull String[] num) {
        this.num = num;
        this.customlistener=customlistener;
    }


    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null);
        return new MyHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, int i) {

        holder.buttonimg.setText(num[i]);
        holder.buttonimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button clickedButton = (Button) v.findViewById(R.id.button);

                button = clickedButton.getText().toString();

                customlistener.onClick(button);
                //Toast.makeText(holder.buttonimg.getContext(),holder.buttonimg.getText(),Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return num.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        Button buttonimg;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            buttonimg = itemView.findViewById(R.id.button);

        }


    }

}
