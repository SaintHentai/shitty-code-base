package com.company;

import java.util.Scanner;

public class Anagram {

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
            int[] count = new int[26];
            for (int i = 0; i < strA.length(); i++) {
                count[strA.charAt(i) - 'a']++;
                count[strB.charAt(i) - 'a']--;
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
