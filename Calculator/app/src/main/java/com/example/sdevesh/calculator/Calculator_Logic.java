package com.example.sdevesh.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Calculator_Logic {
   private  String button="";
   private Set<String> operator=new HashSet<>();
   private Stack<String> Stack = new Stack<>();
    String[] str;
    private String number;
    private String number2;
    private int sum;


    public String logic(String buttonInput) {
        operator.add("+");
        operator.add("-");
        operator.add("*");
        operator.add("/");
        operator.add("=");

        if (operator.contains(buttonInput)) {
            if (Stack.size() == 0) {
                Stack.push(button);
                Stack.push(buttonInput);

            }
            else
                {
                switch (Stack.peek()) {
                    case "+" : {
                        str = button.split(Stack.pop());
                        number = str[1];
                        number2 = Stack.pop();
                        sum = (Integer.parseInt(number) + Integer.parseInt(number2));
                        Stack.push(Integer.toString(sum));
                        button = Stack.peek();
                        return Integer.toString(sum);
                    }
                }

            }

        }


        button = button + buttonInput;


       return button;
    }

}
