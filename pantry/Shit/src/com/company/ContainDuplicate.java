package com.company;

import java.util.Arrays;

public class ContainDuplicate {

    static boolean contain(int[] nums){

        boolean flag = false;

        int count = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) if (nums[i] == nums[i+1]) count++;

        if (count!=0) flag = true;

        return flag;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(contain(arr));
    }
}
