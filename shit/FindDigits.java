package com.company;

import java.util.ArrayList;

public class FindDigits {

    static final int base = 10;

    static int findDigits(long num){
        long mainNum = num;
        long temp;
        int count = 0;
        ArrayList<Long> arr = new ArrayList<>();
        while (num!=0){
            temp = num % base;
            num = num / base;
            if (temp != 0)
                arr.add(temp);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (mainNum % arr.get(i) == 0)
                count++;
        }
        System.out.println(count);
        return count;
    }

    public static void main(String[] args) {
        long[] arr = {12,1012};
        for (int i = 0; i < arr.length; i++) {
            findDigits(arr[i]);
        }
    }

}
