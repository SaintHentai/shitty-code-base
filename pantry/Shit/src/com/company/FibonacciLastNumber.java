package com.company;

import java.util.*;

public class FibonacciLastNumber {

    static List<Long> fibLastNum(long n) {
        List<Long> list = new ArrayList<>();
        long f1 = 0;
        long f2 = 1;
        long new_var;
        list.add(f1);
        for (int i = 0; i < n; i++) {
            list.add(f2);
            new_var = (f1 + f2) % 10;
            f1 = f2;
            f2 = new_var;
        }
        return list;
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        long n = sn.nextLong();
        System.out.println(fibLastNum(n));
        
    }

}
