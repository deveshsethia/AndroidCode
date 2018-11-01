package com.example.bseeram.salestaxapp;

import java.util.ArrayList;
import java.util.List;

public class MyCart {

    List<Item> list = new ArrayList<>();

    public void addListItems(int quantityString, boolean isImported, String type) {
        list.add(new Item(quantityString,isImported,type));
    }
}
