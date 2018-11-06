package com.example.bseeram.salestaxapp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Item {
    private static  List<String> priceList= Arrays.asList("0.0","10.0");

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    private String itemName;
    String type;
    int quantity;
    boolean isImported;
    double price;

    public Item(String itemNameString, int quantity, boolean isImported, String type, String price) {
        this.type=type;
        this.quantity = quantity;
        this.isImported = isImported;
        this.price = Double.parseDouble(price);
        this.itemName=itemNameString;

    }

    static String priceCheck(String type){
        switch(type) {
                   case "Books":
                       return  priceList.get(1);


                       default:
                           return priceList.get(0);

               }





    }


}
