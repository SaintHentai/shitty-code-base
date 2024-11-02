package com.company;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ",arr[i]);
        }
    }

    // cur + x = key
    // x = key - cur
    static int[] twoSum(int[] nums, int key){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int x = key - cur;
            if (map.containsKey(x)){
                return new int[] {map.get(x), i};
            }
            map.put(cur,i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int key = 9;
        display(twoSum(nums,key));

    }

}
