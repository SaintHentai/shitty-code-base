package com.company;

public class RecursiveSum {

    static int superDigit(String n, int k){
        if (n.length() == 1) return Integer.parseInt(n);
        else {
            long sum = sumDigits(n) * k;
            return superDigit(String.valueOf(sum),1);
        }
    }

    static long sumDigits(String n){
        long sum  = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += Long.parseLong(n.substring(i,i+1));
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "9875";
        int a = superDigit(s,4);
        System.out.println(a);
    }

}
