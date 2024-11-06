package com.company;

import java.util.*;

public class LongestConsecutiveSequence {

    static int longestConsecutive(int[] nums){
        int ans = 0;

        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        for (int num: nums) {
            if (!set.contains(num - 1)){
                int count = 1;
                while (set.contains(num + 1)){
                    num++;
                    count++;
                }
                ans = Math.max(count,ans);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int a = longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6});
        System.out.println(a);
    }
}
