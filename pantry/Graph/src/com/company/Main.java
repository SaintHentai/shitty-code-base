package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static long init(int v, List<List<Integer>> arr, int lib, int roads){
        GraphOne theGraphOne = new GraphOne(v);
        int e = arr.size();
        int result = 0;
        for (int i = 1; i <= v; i++) {
            theGraphOne.addVertex(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            theGraphOne.addEdge(arr.get(i));
        }
        /*System.out.print("Visit: ");*/
        theGraphOne.dfs();
        if (theGraphOne.count_cities==v){
            result = Math.min(v * lib,1 * lib + (v-1) * roads);
            System.out.println("00: " + result);
        }else if (theGraphOne.count_cities < v){
            result = Math.min(v * lib,e * roads + 2 * lib );
            System.out.println("01: " + result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> mainArr = new ArrayList<>();
        ArrayList<Integer> one = new ArrayList<>();
        one.add(1);
        one.add(3);
        mainArr.add(one);
        ArrayList<Integer> two = new ArrayList<>();
        two.add(3);
        two.add(4);
        mainArr.add(two);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(2);
        third.add(4);
        mainArr.add(third);
        ArrayList<Integer> four = new ArrayList<>();
        four.add(1);
        four.add(2);
        mainArr.add(four);
        ArrayList<Integer> five = new ArrayList<>();
        five.add(2);
        five.add(3);
        mainArr.add(five);
        ArrayList<Integer> six = new ArrayList<>();
        six.add(5);
        six.add(6);
        mainArr.add(six);

        init(6,mainArr,2,5);
    }
}
