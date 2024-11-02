package com.company;

import java.util.Scanner;

public class BubbleSort {

    static int[] a = {};
    static int count = 0;

    static void init(){
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new int[size];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
    }

    static void swap(int first, int second){
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
        count++;
    }

    static void show(){
        System.out.println(count);
        System.out.println();
        for (int ect: a) System.out.printf("%d ",ect);
    }

    static void bubbleSort(int[] arr){
        for (int out = arr.length - 1; 0 < out; out--) {
            for (int in = 0; in < out; in++)
                if (arr[in] > arr[in + 1])
                    swap(in, in + 1);
        }
    }

    public static void main(String[] args) {
        init();
        bubbleSort(a);
        show();
    }

}
