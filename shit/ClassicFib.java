package com.company;

public class ClassicFib {

    static int iteFib(int n){
        if (n==0) return 0;
        int temp, f1 = 0, f2 = 1;
        for (int i = 0; i < n - 1; i++){
            temp = f2;
            f2 = f1 + f2;
            f1 = temp;
        }
        return f2;
    }

    public static void main(String[] args) {
        System.out.println(iteFib(2));
    }
}
