package com.company;

import java.util.*;

public class FibBigNumMod {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        long n = sn.nextLong();
        long m = sn.nextLong();
        List<Long> arrRemainders = new ArrayList<>();
        long f1 = 0;
        long f2 = 1;
        long temp;
        arrRemainders.add(f1);
        arrRemainders.add(f2);
        for (long i = 0; i < n; i++) {
            temp = f2;
            f2 = (f1 + f2) % m;
            f1 = temp;
            if (f1 == 0 & f2 == 1) break;
            arrRemainders.add(f2);
        }
        arrRemainders.remove(arrRemainders.size()-1);
        int lenPis = arrRemainders.size();
        long answer = arrRemainders.get((int) (n % lenPis));
        System.out.println(answer);
    }

}
