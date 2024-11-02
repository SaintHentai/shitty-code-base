package com.company;

import java.util.Scanner;

public class BinSearchCount {

    static int cur = 0;
    static int[] a = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
        cur = sn.nextInt();
    }

    static int leftBinary(int[] arr, int cur){
        int left = -1;
        int right = arr.length - 1;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;

            if (arr[mid] < cur) left = mid;

            else right = mid;

        }

        if (arr[right] == cur) return right;

        return 0;
    }

    static int rightBinary(int[] arr, int cur){
        int left = 0;
        int right = arr.length;

        while (left + 1 < right){
            int mid = left + (right - left) / 2;

            if (arr[mid] <= cur) left = mid;

            else right = mid;

        }

        if (arr[left] == cur) return left;

        return -1;
    }

    static void count(int[] main, int cur){
        System.out.println(Math.abs(rightBinary(main,cur) - leftBinary(main,cur) + 1));
    }

    public static void main(String[] args) {
        init();
        count(a,cur);
    }

}
