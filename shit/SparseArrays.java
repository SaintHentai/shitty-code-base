package com.company;

import java.util.ArrayList;
import java.util.List;

public class SparseArrays {

    static List<Integer> matchingStrings(List<String> stringList, List<String> queries ){
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int count = 0;
            for (int j = 0; j < stringList.size(); j++) {
                if (queries.get(i).equals(stringList.get(j))){
                    count++;
                    System.out.println(i + " "+ count);
                }
            }
            result.add(count);
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("aba");
        arr2.add("xzxb");
        arr2.add("ab");
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("aba");
        arr1.add("baba");
        arr1.add("aba");
        arr1.add("xzxb");
        matchingStrings(arr1,arr2);
    }

}
