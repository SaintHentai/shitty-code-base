package com.company;

public class BuyAndSellStock {

    static int buyAndSell(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            int val = prices[i] - min;
            System.out.println(prices[i] + " " + min);
            if (max < val) max = val;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,1};
        int a = buyAndSell(arr);
        System.out.println(a);
    }

}
