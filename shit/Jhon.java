package com.company;

import java.io.*;
import java.util.*;

public class Jhon {

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            int[] arr = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pockets(arr);
        }catch (IOException e){}
    }

    static void pockets(int[] arr){
        int[] countsPockets = new int[101];
        for (int ect: arr) {
            countsPockets[ect-1]++;
        }
        int ans = Arrays.stream(countsPockets).max().getAsInt();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        init();
    }

}
