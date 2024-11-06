package com.company;

import java.io.*;
import java.util.*;

public class Keyboard {

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size1 = Integer.parseInt(reader.readLine());
            int[] arr1 = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int size2 = Integer.parseInt(reader.readLine());
            int[] arr2 = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            checkWorkKeyboard(size1,size2,arr1,arr2);
        }catch (IOException e){}
    }

    static void checkWorkKeyboard(int size1, int size2, int[] arr1, int[] arr2){
        for (int i = 0; i < size2; i++) arr1[arr2[i] - 1]--;

        for (int i = 0; i < size1; i++) {
            if (arr1[i] < 0) System.out.println("yes");
            else System.out.println("no");
        }
    }

    public static void main(String[] args) {
        init();
    }
}
