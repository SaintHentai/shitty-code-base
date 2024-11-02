package com.company;

import java.util.ArrayList;

public class TestFindDigits {

    static final int base = 10;

    static void findDigits(long num){
        long temp;
        while (num != 0) {
            temp = num % base;
            num = num / base;
            System.out.printf("%d ", temp);
        }
        //System.out.println(num / base);
    }

    public static void main(String[] args) {
        long[] arr = {123};
        for (int i = 0; i < arr.length; i++) {
            findDigits(arr[i]);
        }
    }

}
