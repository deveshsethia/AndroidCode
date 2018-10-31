package com.example.bseeram.calculator;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Calculate {

    double resultDouble;
    String append="";
    Set<String> numbers = new HashSet<>();
    Set<String> operators = new HashSet<>();
    Stack<String> stack = new Stack<>();

    public String resultCalculator(String clickedValue){

        double op1=0.0,op2;
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");

        if (numbers.contains(clickedValue))
        {
            if (stack.empty() || operators.contains(stack.peek()))
            {
                stack.push(clickedValue);
                return clickedValue;
            }
            else
            {
                append=stack.pop()+clickedValue;
                stack.push(append);
            }
            return append;
        }
        else if (operators.contains(clickedValue))
        {
            stack.push(clickedValue);
            return clickedValue;
        }
        else if (clickedValue.equals("="))
        {
            op2 = Double.parseDouble(stack.pop());
            switch (stack.pop())
            {
                case "+":
                    op1 = Double.parseDouble(stack.pop());
                    resultDouble = op1+op2;
                    stack.push(Double.toString(resultDouble));
                    return Double.toString(resultDouble);
                case "-":
                    op1 = Double.parseDouble(stack.pop());
                    resultDouble = op1-op2;
                    stack.push(Double.toString(resultDouble));
                    return Double.toString(resultDouble);
                case "*":
                    op1 = Double.parseDouble(stack.pop());
                    resultDouble = op1*op2;
                    stack.push(Double.toString(resultDouble));
                    return Double.toString(resultDouble);
                case "/":
                    op1 = Double.parseDouble(stack.pop());
                    resultDouble = op1/op2;
                    stack.push(Double.toString(resultDouble));
                    return Double.toString(resultDouble);
            }
        }
        else if (clickedValue.equals("C"))
            stack.pop();
        return "";
    }
}
