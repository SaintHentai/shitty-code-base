package com.company;

import java.io.*;

public class CounterSortVerNegative {

    static int[] a = {};
    static int[] counts = {};
    static int countSize = 0;

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            a = new int[size];
            String[] subs = reader.readLine().split("\\s+");
            for (int i = 0; i < size; i++){
                a[i] = Integer.parseInt(subs[i]);
            }
        }catch (IOException e){}
    }

    static void countSort() {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            if (max <= a[i]) max = a[i];
            if (min >= a[i]) min = a[i];
        }

        int absMin = Math.abs(min);
        countSize = max + absMin + 1;
        counts = new int[countSize];

        for (int ect: a) counts[ect + absMin]++;

        for (int out = countSize - 1; 0 <= out; out--) {
            for (int in = 0; in < counts[out]; in++) {
                System.out.printf("%d ", out - absMin);
            }
        }
    }

    static void show(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print("ind=" + i + " val=" + arr[i] + " | ");
        }
    }

    public static void main(String[] args) {
        init();
        countSort();
        //show(a);
    }

}
