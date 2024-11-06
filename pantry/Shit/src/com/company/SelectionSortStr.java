package com.company;

import java.io.*;
import java.util.*;

public class SelectionSortStr {

    static int lastThreePositions = 4; // (arr.len - 1) - 3
    static ArrayList<Element> hash = new ArrayList<>();

    static class Element {
        String name;
        int rank;

        Element(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }
    }

    static void show(){
        for (int i = hash.size() - 1; hash.size() - lastThreePositions < i; i--)
            System.out.println(hash.get(i).name + " " + hash.get(i).rank);
    }

    static void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int size = Integer.parseInt(reader.readLine());
            for (int i = 0; i < size; i++){
                String[] subs = reader.readLine().split("\\s+");
                hash.add(new Element(subs[0] + " " + subs[1], Integer.parseInt(subs[2])));
            }
        }catch (IOException e){}
    }

    static void selectionSort(List<Element> arr) {
        for (int out = arr.size() - 1; arr.size() - lastThreePositions < out; out--) {
            int maxInd = out;
            for (int in = 0; in < out; in++)
                if (arr.get(in).rank > arr.get(maxInd).rank) maxInd = in;

            if (maxInd != out) Collections.swap(arr, maxInd, out);
        }
    }

    public static void main(String[] args) {
        init();
        selectionSort(hash);
        show();
    }

}
