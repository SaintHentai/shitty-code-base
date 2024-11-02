package com.company;

import java.util.*;

public class BinSearchCountList {

    static int[] a = {};
    static int[] b = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        int sizeA = sn.nextInt();
        a = new int[sizeA];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
        int sizeB = sn.nextInt();
        b = new int[sizeB];
        for (int i = 0; i < b.length; i++) {
            b[i] = sn.nextInt();
        }
    }

    static int leftBinarySearch(int[] array, int cur) {
        int left = -1;
        int right = array.length - 1;
        while (left + 1 < right)
        {
            int m = left + (right - left) / 2;

            if (array[m] < cur)
                left = m;
            else
                right = m;
        }

        if (array[right] == cur)
            return right;
        return 0;
    }

    static int rightBinarySearch(int[] array, int cur) {
        int left = 0;
        int right = array.length;
        while (left + 1 < right)
        {
            int m = left + (right - left) / 2;

            if (array[m] <= cur)
                left = m;
            else
                right = m;
        }

        if (array[left] == cur)
            return left;

        return -1;
    }

    /*static int getSizeDiffElements(int[] arr, int cur) {
        int firstInd = leftBinarySearch(arr, cur);
        if (firstInd == -1) {
            return 0;
        }
        return rightBinarySearch(arr, cur) - firstInd + 1;
    }*/

    static int getSizeDiffElements(int[] arr, int cur) {
        return Math.abs(rightBinarySearch(arr, cur) - leftBinarySearch(arr, cur) + 1);
    }

    static void count(int[] check, int[] main){
        for (int ect: main){
            int a = getSizeDiffElements(check,ect);
            System.out.printf("%d ",a);
        }
    }

    public static void main(String[] args) {
        init();
        count(a,b);
    }

}
