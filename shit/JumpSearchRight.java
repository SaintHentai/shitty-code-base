package com.company;

import java.util.Scanner;

public class JumpSearchRight {

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

    static int rightJump(int[] array, int cur) {
        int B = (int) Math.sqrt(array.length);

        int start = 0;
        int end = B - 1;

        while (array[end] <= cur && end < array.length - 1 && array[end + 1] <= cur)
        {
            start = Math.min(array.length - 1, start + B);
            end = Math.min(array.length - 1, end + B);
        }

        if (cur > array[end])
        {
            return -1;
        }

        for (int i = end; i >= start; i--)
        {
            if (array[i] == cur)
            {
                return i;
            }
        }

        return -1;
    }

    static void getResult(int[] sorted, int[] main){
        for (int cur: main) {
            System.out.println(rightJump(sorted,cur) + 1);
        }
    }

    public static void main(String[] args) {
        /*String[] strA = "1 1 3 3 5 7 9 18 18 57".split(" ");
        String[] strB = "57 3 9 1 179".split(" ");

        int[] arrA = new int[strA.length];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = Integer.parseInt(strA[i]);
        }

        int[] arrB = new int[strB.length];
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = Integer.parseInt(strB[i]);
        }

        getResult(arrA,arrB);*/

        init();
        getResult(a,b);

    }

}
