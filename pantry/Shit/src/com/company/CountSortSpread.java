package com.company;

/*
*
* Первый:  выведет первые числа в диапазоне 107, потеряв при этом конец.
* Второй:  выведет последние числа в диапазоне 107, потеряв при этом начало.
*
* Пример с первым:
* 7
*
* 100 207 157 102 200 154 208
*
* 100 102 154 157 200 207
*
* Пример с вторым:
* 7
* 100 207 157 102 200 154 208
*
* 102 154 157 200 207 208
*
* Изначально я писал орентируясь на конец.
* Так как конец массива мне кажется важней чем начало,
* поэтому вычисления минимума идет по отношению найденного максимума.
* */

import java.io.*;
import java.util.*;

public class CountSortSpread {
    static HashMap<Integer, List<Integer>> hm = new HashMap<>();

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            countSort(arr);
        }catch (IOException e){}
    }

    //первый
    /*static void countSort(int[] arr) {
        if (arr.length == 0) return;

        int min = Integer.MAX_VALUE;
        for (int ect: arr) if (min >= ect) min = ect;

        int[] counts = new int[108];

        for (int ect : arr) {
            int key = ect - min;
            if (key <= 107) counts[key]++;
        }

        for (int out = 0; out < counts.length; out++) {
            for (int in = 0; in < counts[out]; in++) {
                System.out.print(out + min + " ");
            }
        }
    }*/

    //второй
    static void countSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int ect: arr) if (max <= ect) max = ect;

        for (int ect: arr) {
            if ((max - ect) <= 107 && ect < min) min = ect;
            if (!hm.containsKey(ect)) hm.put(ect, new ArrayList<>());
            hm.get(ect).add(1);
        }

        for (int key = min; key < max + 1; key++) {
            if (hm.containsKey(key)) {
                for (int i = 0; i < hm.get(key).size(); i++) System.out.print(key +" ");
            }
        }
    }

    public static void main(String[] args) {
        init();
    }
}