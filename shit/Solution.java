package com.company;

import java.util.*;

public class Solution {

    static int[] input = new int[2];
    static int[] a = {};
    static int[] b = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {
            input[i]  = sn.nextInt();
        }
        a = new int[input[0]];
        b = new int[input[1]];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sn.nextInt();
        }
    }

    static void getArrayValues(int[] check, int[] main){
        for (int ect: main) {
            int index = Arrays.binarySearch(check, ect);
            if (index >= 0)                     System.out.println(check[index]);
            else {
                index =-(index + 1);
                if (index == 0)                 System.out.println(check[index]);
                else if (index == check.length) System.out.println(check[index - 1]);
                else {
                    int head = Math.abs(check[index - 1] - ect);
                    int tail = Math.abs(check[index] - ect);
                    System.out.println(head <= tail ? check[index - 1] : check[index]);
                }
            }
        }

    }

    public static void main(String[] args) {
        /*getCloseValues(new int[]{1,2000000000},-2000000000);*/
        getArrayValues(new int[]{1, 3, 5, 7, 9},new int[]{2, 4, 8, 11, 6});
        /*init();
        getArrayValues(a,b);*/
    }
}
