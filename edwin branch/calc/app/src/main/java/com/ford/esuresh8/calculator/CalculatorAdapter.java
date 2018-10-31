package com.ford.esuresh8.calculator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorAdapter extends RecyclerView.Adapter<CalculatorAdapter.ViewHolder> {
    private String[] mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    CalculatorAdapter(Context context, String[] data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.calc_items, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.clickedInput.setText(mData[i]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView clickedInput;

        ViewHolder(View itemView){
            super(itemView);
            clickedInput = itemView.findViewById(R.id.calc_values);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if (mClickListener != null)
                mClickListener.onItemClick(v, getAdapterPosition());
        }
    }
    String getItem(int id) {
        return mData[id];
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
