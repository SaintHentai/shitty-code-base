package com.company;

import java.util.Scanner;

public class JumpCount {

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

    static int leftJump(int[] array, int cur) {
        int B = (int) Math.sqrt(array.length);

        int start = 0;
        int end = B - 1;

        while (array[end] < cur)
        {
            if (end == array.length - 1)
            {
                break;
            }

            start = Math.min(array.length - 1, start + B);
            end = Math.min(array.length - 1, end + B);
        }

        if (cur > array[end])
        {
            return 0;
        }

        for (int i = start; i <= end; i++)
        {
            if (array[i] == cur)
            {
                return i;
            }
        }

        return 0;
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

    static void getDiffCount(int[] array, int cur){
        System.out.println(rightJump(array, cur) - leftJump(array, cur) + 1);
    }

    public static void main(String[] args) {
        init();
        getDiffCount(a,cur);
    }

}
