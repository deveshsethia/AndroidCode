package com.example.bseeram.salestaxapp;

public class EnableButtons {


    public String checkEnablity(String itemNameString, String quantityString, int radioChecked) {
        if (itemNameString.isEmpty() || quantityString.isEmpty() || radioChecked==-1){
            return "Please enter the details!";
        }
        return "Congrats!! You have successfully added the item.";
    }

    public void clickAddItem() {


    }
}
