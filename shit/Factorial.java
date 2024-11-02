package com.company;

import java.math.BigInteger;

public class Factorial {

    static BigInteger factorial(int n){
        if (n==0)
            return BigInteger.valueOf(1);
        else
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
    }
    static void f(int n){
        BigInteger a = factorial(n);
        System.out.println(a);
    }

    public static void main(String[] args) {
        BigInteger a = factorial(25);
        System.out.println(a);
    }
}
