package com.company;

import java.util.*;

public class CounterSort {

    static String[] a = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new String[size + 1];
        for (int i = 0; i < a.length; i++)
            a[i] = sn.nextLine();
    }

    /*static void showWork(int[] arr,HashMap<Integer,List<Integer>> hm){
        Arrays.stream(arr).forEach((v) -> System.out.printf("%d ",v));
        System.out.println();
        System.out.println(hm);
    }*/

    /*static void counterSort(String[] arr){
        int count = Integer.MAX_VALUE;
        int minLen = 0;

        HashMap<Integer, List<Integer>> hm1 = new HashMap<>();
        HashMap<Integer, List<Integer>> hm2 = new HashMap<>();

        for (String ect: arr) {
            int key = ect.length();
            if (!hm1.containsKey(key)) hm1.put(key, new ArrayList<>());
            hm1.get(key).add(key);
        }

        for (String ect: arr) {
            int key = ect.length();
            int subKey = 0;
            if (key!=0) subKey = hm1.get(key).size();
            if (!hm2.containsKey(subKey)) hm2.put(subKey, new ArrayList<>());
            if (!hm2.get(subKey).contains(key)) hm2.get(subKey).add(key);
            if (subKey != 0 && subKey < count) count = subKey;
        }
        minLen = hm2.get(count).stream().min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println(minLen + " " + count);
    }*/

    static void counterSort(String[] arr){
        int count = Integer.MAX_VALUE;
        int minLen = 0;

        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        int[] counter = new int[1001];

        for (String ect: arr) {
            int key = ect.length();
            counter[key] = counter[key]+1; // first ind 0 --> have count 1
        }

        for (String ect: arr) {
            int key = ect.length(); //initial key == 0
            int subKey = 0;
            if (key!=0) subKey = counter[key];
            if (!hm.containsKey(subKey)) hm.put(subKey, new ArrayList<>());
            if (!hm.get(subKey).contains(key)) hm.get(subKey).add(key);
            if (subKey !=0 && subKey < count) count = subKey;
        }
        minLen = hm.get(count).stream().min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println(minLen + " " + count);
    }

    public static void main(String[] args) {
        init();
        counterSort(a);
    }

}
