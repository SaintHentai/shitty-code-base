package com.company;

//solution debug from https://stepik.org/lesson/124573/step/10?unit=756166

import java.util.*;

public class InsertSort {

    static int[] a = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
    }

    static void show(int[] arr, int count){
        for (int ect : arr) System.out.printf("%d ",ect);
        System.out.println(" |" + count);
    }

    static void insertSort(int[] arr){
        for (int out = 1; out < arr.length; out++) {
            int next = arr[out];
            int prev = out;
            while (prev > 0 && arr[prev - 1] > next){
                arr[prev] = arr[prev - 1];
                prev--;
            }
            if (arr[prev] != next) {
                arr[prev] = next;
                show(arr, out);
            }
        }
    }

    public static void main(String[] args) {
        //int[] arr = {7,4,3,5,6,2};
        init();
        insertSort(a);

    }
}
