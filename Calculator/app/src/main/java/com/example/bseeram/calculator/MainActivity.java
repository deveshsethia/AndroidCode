package com.example.bseeram.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bseeram.calculator.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> list = Arrays.asList("7","8","9","C","4","5","6","+","1","2","3","-","0",".","=","*","/");
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;
    EditText editText;
    Calculate calculate = new Calculate();

    CustomListener customListener = new CustomListener() {
        @Override
        public void onClick(String clickedValue) {
            editText.setText(calculate.resultCalculator(clickedValue));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(MainActivity.this, 4);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter myAdapter = new MyAdapter(customListener, list);
        recyclerView.setAdapter(myAdapter);

    }

}
