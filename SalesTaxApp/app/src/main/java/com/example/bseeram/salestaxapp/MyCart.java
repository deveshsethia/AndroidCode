package com.example.bseeram.salestaxapp;

import java.util.ArrayList;
import java.util.List;

public class MyCart {
   static MyCart instance =null;
    public List<Item> list = new ArrayList<>();
    private MyCart(){

    }

    static public MyCart getInstance() {
        if(instance==null)
            instance =new MyCart();

        return instance;
    }

     public void addListItems(String itemNameString, int quantityString, boolean isImported, String type , String price) {
        list.add(new Item(itemNameString,quantityString,isImported,type,price));
      }

    }

