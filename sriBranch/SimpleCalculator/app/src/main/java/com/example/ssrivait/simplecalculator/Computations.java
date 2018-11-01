package com.example.ssrivait.simplecalculator;

public class Computations {

    public  int calcLogic(int data1,String data2,String opr)
    {

       if(opr=="+") { return Integer.parseInt(data2)+data1; }
       else if(opr=="-") { return Integer.parseInt(data2)-data1; }
           else if(opr=="*") { return Integer.parseInt(data2)*data1; }
                else if(opr=="/") { return Integer.parseInt(data2)/data1; }
         else {return 0;}
        //return 0;
    }
}
