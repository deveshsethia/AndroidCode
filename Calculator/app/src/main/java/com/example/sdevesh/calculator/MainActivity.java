package com.example.sdevesh.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sdevesh.calculator.adapter.Customlistener;
import com.example.sdevesh.calculator.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    TextView textView;
    Calculator_Logic calculator_logic=new Calculator_Logic();
    Customlistener customlistener = new Customlistener() {
        @Override
        public void onClick(String s) {

            textView.setText(calculator_logic.logic(s));
        }
    };

    private String buttonList[] = {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","del","+","="};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = findViewById(R.id.text);
        recyclerView = findViewById(R.id.recycle_view);
        layoutManager = new GridLayoutManager(this, 4);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(customlistener, buttonList);
        // myAdapter.setClickListener(this);

        recyclerView.setAdapter(myAdapter);
    }




}
