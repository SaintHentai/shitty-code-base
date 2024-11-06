package com.company;

import java.io.*;
import java.util.*;

public class BubbleStrFirst {

    static ArrayList<Element> hash = new ArrayList<>();

    static class Element {
        String name;
        double averageRank;

        Element(String name, double averageRank) {
            this.name = name;
            this.averageRank = averageRank;
        }
    }

    static void show(){
        for (Element ect: hash) {
            System.out.println(ect.name + " " + ect.averageRank);
        }
    }

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++){
                String[] subs = reader.readLine().split("\\s+");
                String name = subs[0] + " " + subs[1];
                double averageRank = (Integer.parseInt(subs[2]) + Integer.parseInt(subs[3]) + Integer.parseInt(subs[4])) / 3.0;
                hash.add(new Element(name, averageRank));
            }
        }catch (IOException e){}
    }

    static void bubbleSort(List<Element> arr){
        for (int out = arr.size() - 1; 0 < out; out--) {
            boolean flag = false;
            for (int in = 0; in < out; in++)
                if (arr.get(in).averageRank < arr.get(in + 1).averageRank) { // decreasing
                    Collections.swap(arr,in, in + 1);
                    flag = true;
                }
            if (flag == false) return;
        }
    }

    public static void main(String[] args) {
        init();
        bubbleSort(hash);
        show();
    }

}
