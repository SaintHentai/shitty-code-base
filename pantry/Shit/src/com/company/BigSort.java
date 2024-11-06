package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BigSort {
    
    static List<String> sort(List<String> list){

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (s.length() > t1.length()) return 1;
                else if (s.length() < t1.length()) return -1;
                else {
                    BigInteger a = new BigInteger(s);
                    BigInteger b = new BigInteger(t1);
                    return a.compareTo(b);
                }
            }
        });
        return list;
    }


    public static void main(String[] args) {
        String str = "31415926535897932384626433832795\n" +
                "1\n" +
                "3\n" +
                "10\n" +
                "3\n" +
                "5";
        String[] a = str.split("\n");
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            arr.add(a[i]);
        }
        System.out.println(sort(arr));
    }
}
