package com.example.bseeram.salestaxapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.arch.lifecycle.Transformations.map;
import static com.example.bseeram.salestaxapp.Item.map;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    List<String> itemList = Arrays.asList("Choose the type of the item","Books","Food","Medicines","Accessories","Electronics","Furniture","Clothing");
    ArrayAdapter<String> arrayAdapter;
    Button addItem;
    EditText itemName,quantity;
    RadioGroup radioGroup;
    TextView price;
    EnableButtons enableButtons = new EnableButtons();
    MyCart myCart = new MyCart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner=findViewById(R.id.category);
        arrayAdapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, itemList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        addItem = findViewById(R.id.addItem);
        itemName = findViewById(R.id.itemName);
        quantity = findViewById(R.id.quantity);
        radioGroup = findViewById(R.id.group);
        price = findViewById(R.id.price);

        spinner.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    String type=spinner.getSelectedItem().toString();
                    price.setText(map.get(type).toString());
                }
                return false;
            }
        });

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemNameString = itemName.getText().toString();
                String quantityString = quantity.getText().toString();
                int radioChecked = radioGroup.getCheckedRadioButtonId();
                String message = enableButtons.checkEnablity(itemNameString, quantityString, radioChecked);
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                myCart.addListItems(Integer.parseInt(quantityString), checkImported(), spinner.getSelectedItem().toString());

            }
        });



    }
    private boolean checkImported() {

        return radioGroup.getCheckedRadioButtonId() == R.id.imported;
    }
}
