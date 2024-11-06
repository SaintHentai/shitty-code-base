package com.company;

import java.io.*;
import java.util.*;

public class PutArray {

    static int[] mainArr = {};
    static int element, pos, size;

    static void init() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(reader.readLine());
        String[] ar = reader.readLine().split("\\s+");
        String[] br = reader.readLine().split("\\s+");
        mainArr = Arrays.stream(ar).mapToInt(Integer::parseInt).toArray();
        element = Integer.parseInt(br[0]);
        pos = Integer.parseInt(br[1]);
    }

    static void insert(int[] arr, int x, int pos){
        int[] new_arr = new int[size + 1];
        for (int i = 0; i < size + 1; i++) {
            if (i < pos - 1)        new_arr[i] = arr[i];
            else if (i == pos - 1)  new_arr[i] = x;
            else if (i > pos - 1)   new_arr[i] = arr[i - 1];
        }
        Arrays.stream(new_arr).forEach((v) -> System.out.printf("%d ",v));
    }

    public static void main(String[] args) throws IOException{
        //int[] arr = {7,4,3,5,6,2};
        init();
        insert(mainArr,element,pos);
    }
}
