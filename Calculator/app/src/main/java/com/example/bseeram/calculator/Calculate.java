package com.example.bseeram.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Calculate {

    String result,append="";
    Set<String> numbers = new HashSet<>();
    Set<String> operators = new HashSet<>();
    Stack<String> stack = new Stack<>();

    public String resultCalculator(String clickedValue){

        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        numbers.add("0");

        if (numbers.contains(clickedValue))
        {
            if (stack.empty())
            {
                stack.push(clickedValue);
                return clickedValue;
            }
            else
            {
                append=stack.peek()+clickedValue;
                stack.push(clickedValue);
            }
            return append;
        }
        else
            return "";
    }
}
