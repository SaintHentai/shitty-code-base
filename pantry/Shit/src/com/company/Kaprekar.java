package com.company;


public class Kaprekar {

    public static void kaprekarNumbers(int start, int end){
        int base;
        boolean flag = false;
        for (int n = start; n <= end; ++n){
            int exp = Integer.toString(n).length();
            base = (int) Math.pow(10,exp);
            long n_sqrt = (long) Math.pow(n,2);
            long beta = n_sqrt % base;
            long alpha = (n_sqrt - beta) / base;
            if ((alpha + beta) == n){
                System.out.printf("%d ", n);
                flag = true;
            }
        }
        if (flag==false)
            System.out.printf("%s", "INVALID RANGE");
    }

    public static void main(String[] args) {
        kaprekarNumbers(1,100);
    }
}
