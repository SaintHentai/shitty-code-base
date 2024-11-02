package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LinearSearch {

    public static int lin_count(List<Integer> arr, int cur){
        int res;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        ArrayList<Integer> keySet = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++){
            int key = Math.abs(cur - arr.get(i));
            keySet.add(key);
            if (!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(arr.get(i));
        }
        System.out.println(hm);
        Collections.sort(keySet);
        int min = keySet.get(0);
        Collections.sort(hm.get(min));
        res = hm.get(min).get(hm.get(min).size() - 1);

        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        String s = bufferedReader.readLine();
        int cur = Integer.parseInt(s);
        int result = lin_count(ar,cur);
        System.out.println(result);
        bufferedReader.close();
    }

}
