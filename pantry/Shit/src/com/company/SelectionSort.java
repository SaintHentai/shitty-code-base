package com.company;

import java.util.*;

public class SelectionSort {

    static int[] a = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
    }

    static void show(){
        for (int ect: a) {
            System.out.printf("%d ",ect);
        }
    }

    static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static void selectionSort(int[] arr){
        for (int out = arr.length - 1; 0 < out; out--) {
            int maxInd = out;
            for (int in = 0; in < out; in++)
                if (arr[in] < arr[maxInd]) maxInd = in; // increase in > maxInd, decreasing in < maxInd


            if (maxInd != out) swap(arr, maxInd, out);
        }
    }

    public static void main(String[] args) {
        init();
        selectionSort(a);
        show();
    }

}
