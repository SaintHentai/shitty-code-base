package com.company;

import java.math.BigDecimal;

public class LogarithmBinSearch {

    static void calcLog(int val){
        int res = 0;

        double log = Math.log(val) / Math.log(2);
        int lenAfterDot = BigDecimal.valueOf(log).scale();
        if (lenAfterDot !=1 ) res = (int) log + 1;
        else                  res = (int) log;

        System.out.println(res);
    }

    public static void main(String[] args) {
        calcLog(5);
    }

}
