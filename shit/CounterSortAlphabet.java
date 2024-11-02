package com.company;

import java.io.*;
import java.util.*;

public class CounterSortAlphabet {

    static List<String> words = new ArrayList<>();
    static int[] alphabet = new int[26];

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++){
                String[] subs = reader.readLine().split("\\s+");
                for (String ect: subs) {
                    if (ect.length() != 0) words.add(ect);
                }
            }
        }catch (IOException e){}
    }

    static void show(){
        int makeStep = 97;
        for (int i = 'a'; i <= 'z'; i++) {
            int ind = i - makeStep;
            if (alphabet[ind] != 0) System.out.println((char)i + " " + alphabet[ind]);
        }
    }

    static void countAlphabet() {
        for (String ect: words) alphabet[ect.charAt(0) - 'a']++;
    }

    public static void main(String[] args) {
        init();
        countAlphabet();
        show();
    }

}
