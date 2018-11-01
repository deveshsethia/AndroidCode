package com.example.bseeram.salestaxapp;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;


public class Item {

    String type;
    int quantity;
    boolean isImported;
    double price;

    public Item(int quantity, boolean isImported, String type) {
        this.type=type;
        this.quantity = quantity;
        this.isImported = isImported;
        this.price = map.get(type);

    }

    static final Map<String,Double> map = new HashMap<>();


  {
            map.put("Books",10.0);
            map.put("Food",10.0);
            map.put("Medicines",10.0);
            map.put("Accessories",10.0);
            map.put("Electronics",10.0);
            map.put("Furniture",10.0);
            map.put("Clothing",10.0);
    }


}
