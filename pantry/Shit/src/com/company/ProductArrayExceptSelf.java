package com.company;

public class ProductArrayExceptSelf {

    static int[] product(int[] nums){
        int[] save = new int[nums.length];
        int countZero = 0;
        int val = 1;
        for (int cur: nums) {
            if (cur != 0) val = val * cur;
            else          countZero++;
        }

        if (countZero==1)
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0)  save[i] = val;
                else               save[i] = 0;
            }
        else if (1 < countZero)
            for (int i = 0; i < nums.length; i++) {
                save[i] = 0;
            }
        else{
            for (int i = 0; i < nums.length; i++)
                save[i] = val / nums[i];
        }
        for (int cur: save) {
            System.out.print(cur+" ");
        }

        return save;
    }

    public static void main(String[] args) {
        product(new int[]{-1,1,0,-3,3});
    }

}
