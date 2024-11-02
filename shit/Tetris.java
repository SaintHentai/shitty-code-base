package com.company;

import java.io.*;
import java.util.*;

public class Tetris {

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = reader.readLine().split("\\s+");
            int size = Integer.parseInt(str[0]);
            int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            show(size,arr);
        }catch (IOException e){}
    }

    static void show(int size, int[] arr){
        int min = Integer.MAX_VALUE;
        int[] column = new int[size + 1];

        for (int key: arr) column[key]++;
        for (int i = 1; i < column.length; i++) if (column[i] < min) min = column[i];

        System.out.println(min);
    }

    public static void main(String[] args) {
        init();
    }

}
