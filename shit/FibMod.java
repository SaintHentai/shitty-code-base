package com.company;

import java.util.*;

public class FibMod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long m = in.nextLong();
        List<Long> list = new ArrayList<>();
        long f1 = 0;
        long f2 = 1;
        long temp;
        list.add(f1);
        list.add(f2);
        for (long i = 0; i < n; i++) {
            temp = f2;
            f2 = (f1 + f2) % m;
            f1 = temp;
            if (f1 == 0 & f2 == 1) break;
            list.add(f2);
        }
        System.out.println(list.get((int)(n % (list.size()-1))));
    }
}
