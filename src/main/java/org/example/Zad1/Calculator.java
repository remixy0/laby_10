package org.example.Zad1;

public class Calculator {
    public static double divide(double dividend, double divisor) throws ArithmeticException{
        if(divisor == 0) throw new ArithmeticException("Division by zero");
        else{
            return dividend/divisor;
        }


    }
}
