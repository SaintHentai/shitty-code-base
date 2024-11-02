package com.company;

import java.util.*;

public class BubbleStr {

    static double key = 0;
    static String[] a = {};
    static ArrayList<Double> keySet = new ArrayList<>();
    static HashMap<Double, List<String>> hm = new HashMap<>();

    static void init()  {
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();
        a = new String[size+1];
        for (int i = 0; i < a.length; i++)
            a[i] = sn.nextLine();
    }

    static void change(){

        for (int i = 0; i < a.length; i++) {
            String ect = a[i];

            String temp_int;
            String temp_str;

            temp_int = ect.replaceAll("[^0-9]","");
            temp_str = ect.replaceAll("[^A-Za-z]"," ");

            int sum = 0;
            char[] arr_ch = temp_int.toCharArray();
            for (char ch: arr_ch) {
                sum = sum + Integer.parseInt(String.valueOf(ch));
            }

            if (arr_ch.length != 0){

                key =  sum / 3.0;

                if (!hm.containsKey(key)) hm.put(key, new ArrayList<>());

                hm.get(key).add(temp_str);

                if (!keySet.contains(key)) keySet.add(key);
            }
        }
    }

    static void show(){
        //System.out.println(hm);
        for (double ect: keySet) hm.get(ect).forEach((v) -> System.out.println(v));
    }

    static void bubbleSort(List<Double> arr){
        for (int out = arr.size() - 1; 0 < out; out--) {
            boolean flag = false;
            for (int in = 0; in < out; in++)
                if (arr.get(in) < arr.get(in + 1)) {
                    Collections.swap(arr,in, in + 1);
                    flag = true;
                }
            if (flag == false) return;
        }
    }

    public static void main(String[] args) {
        init();
        change();
        bubbleSort(keySet);
        show();
    }
}
