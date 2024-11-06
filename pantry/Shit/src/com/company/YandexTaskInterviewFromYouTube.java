package com.company;

import java.util.Arrays;

public class YandexTaskInterviewFromYouTube {

    static int abs(int a){
        return Math.abs(a);
    }

    static void orderPowTwo(int[] arr){

        int left = 0;
        int right = arr.length - 1;
        int[] dump = new int[arr.length];

        for (int cur = arr.length - 1; 0 < cur; cur--) {
            if (abs(arr[left]) <= abs(arr[right])) {
                dump[cur] = arr[right] * arr[right];
                right--;
            }else {
                dump[cur] = arr[left] * arr[left];
                left++;
            }
        }

        Arrays.stream(dump).forEach((v) -> System.out.printf("%d ", v));

    }

    public static void main(String[] args) {
        int[] a = {-4,-1, 1,0,3,10};
        orderPowTwo(a);
    }

}
