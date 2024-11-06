package com.company;

import java.util.Scanner;

public class AnagramNum {

    static void init(){
        Scanner sn = new Scanner(System.in);
        String s1 = sn.nextLine();
        String s2 = sn.nextLine();
        if (isAnagram(s1,s2)) System.out.println("YES");
        else System.out.println("NO");
    }

    static boolean isAnagram(String strA, String strB){
        boolean flag = true;
        if (strA.length() != strB.length())
            flag = false;
        else {
            int[] count = new int[10];
            for (int i = 0; i < strA.length(); i++) {
                int indA = Integer.parseInt(strA.substring(i,i+1));
                int indB = Integer.parseInt(strB.substring(i,i+1));
                count[indA]++;
                count[indB]--;
            }
            for (int i = 0; i < count.length; i++)
                if (count[i] != 0) flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        init();
    }
}
