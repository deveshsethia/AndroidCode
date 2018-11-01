package com.example.ssrivait.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements Itemclick {

    private RecyclerView recyclerView;
    private MyRecyclerViewAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView textview, textview2;

   Computations comp=new Computations();
    StringBuilder sb=new StringBuilder();

    Pattern p=Pattern.compile("[0-9]");
    Matcher m;
    String value1=null,value2;
    int sum=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvNumbers);
        textview = (TextView)findViewById(R.id.number);
        textview2 = findViewById(R.id.output);



        layoutManager = new GridLayoutManager(this, 4);

        String data[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=", "."};

        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecyclerViewAdapter(this, data);

        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onItemClick(View view, int Position) {
        String sym="no";
    String str=adapter.getData(Position);
    m=p.matcher(str);

       // if(sum==0){sum=comp.calcLogic(0,null,"+");}

        if(m.find()) {
            sb.append(adapter.getData(Position));
            textview.setText(sb.toString());
//            if(sym==null){sum=sb.toString();}
//            else{value1=sb.toString();}

           // if(sym!=null){value1=sb.toString();}

        }
        else {
            sym = str;
           value1=sb.toString();
           //value2=sb.toString();
           //sum=Integer.parseInt(value2);
            sb=new StringBuilder();
        }

      // if(sum==0){sum=comp.calcLogic(sum,sb.toString(),sym);}



        if(sb.length()==0){
            sum=comp.calcLogic(sum,value1,sym);

            textview2.setText(String.valueOf(sum));

          // Log.i("TAG","Result" +sum);
                // Log.i("TAG","You clicked"+adapter.getItemId(Position)+",which is at position"+ Position);
        }



       // comp.calcLogic(result);



    }
}
