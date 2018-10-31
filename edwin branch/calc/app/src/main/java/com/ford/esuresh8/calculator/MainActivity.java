package com.ford.esuresh8.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CalculatorAdapter.ItemClickListener {

    CalculatorAdapter calculatorAdapter;
    float input1=0,input2=0;
    String operator="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = {"1","2","3","X","4","5","6","/","7","8","9","+","0","=","-","\u232b","C"};

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        int numberOfColumns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        calculatorAdapter = new CalculatorAdapter(this,data);

        calculatorAdapter.setClickListener(this);
        recyclerView.setAdapter(calculatorAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        String text="";
        StringBuilder sb;

        TextView textView = (TextView)findViewById(R.id.text_display);
        TextView subTextView= (TextView)findViewById(R.id.subtext_display);
        String value=calculatorAdapter.getItem(position);
        text=textView.getText().toString();

        if(text.length()==0){
            text="0";
        }

        if(value=="C"){
            textView.setText("");
            subTextView.setText("");
            text="";
            input1=0;
        }

        else if(value=="\u232b") {
            sb=new StringBuilder(text);
            if(text.length()>0)
                sb.deleteCharAt(text.length() - 1);
                textView.setText(sb);
        }

        else if(value=="+"||value=="-"||value=="X"||value=="/"||value=="="){
            //operator=value;
            input2=Float.parseFloat(text);

            if(operator=="")
                operator=value;
            else if(operator=="+"){
                operator=value;
                input1+=input2;
                subTextView.setText(Float.toString(input1));
                textView.setText("");
            }
            else if(operator=="-"){
                operator=value;
                input1-=input2;
                subTextView.setText(Float.toString(input1));
                textView.setText("");
            }
            else if(operator=="X"){
                operator=value;
                input1*=input2;
                subTextView.setText(Float.toString(input1));
                textView.setText("");
            }
            else if(operator=="/"){
                operator=value;
                input1/=input2;
                subTextView.setText(Float.toString(input1));
                textView.setText("");
            }
            else if(operator=="="){
                operator="";
                subTextView.setText("");
                textView.setText(Float.toString(input1));
            }
        }
        else{
            textView.setText(textView.getText() + calculatorAdapter.getItem(position));
        }
    }
}
