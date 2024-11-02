package com.company;

import java.io.*;
import java.util.*;

public class CounterSortStr {

    static int keys = 1000001;
    static HashMap<Integer, List<String>> hm = new HashMap<>();

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++){
                String[] subs = reader.readLine().split("\\s+");
                int key = Integer.parseInt(subs[2]);
                if (!hm.containsKey(key)) hm.put(key, new ArrayList<>());
                hm.get(key).add(subs[0] + " " + subs[1]);
            }
        }catch (IOException e){}
    }

    static void countSort(){
        int countUsedKeys = 0;
        for (int key = keys; 0 < key; key--) {
            if (hm.containsKey(key)) {
                countUsedKeys = countUsedKeys + hm.get(key).size();
                hm.get(key).stream().forEach((V)->System.out.println(V));
            }
            if (3<=countUsedKeys) break;
        }
    }

    public static void main(String[] args) {
        init();
        countSort();
    }

}
