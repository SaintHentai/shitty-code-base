package com.company;

import java.util.*;

public class TopKFrequent {

    static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        // подсчет количества каждого значения в массиве
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        //достаем список ключей 1 2 3
        List<Integer> list = new ArrayList<>(map.keySet());
        //упорядочивание количества значений в убывающем порядке 3 2 1
        Collections.sort(list, (a,b) -> map.get(b) - map.get(a));
        //достаем из списка ключи которые ранее были упорядочены в порядке убывания
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = topKFrequent(new int[]{1,1,1,2,2,3},2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
