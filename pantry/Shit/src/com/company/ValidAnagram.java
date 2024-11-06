package com.company;

import java.util.*;

public class ValidAnagram {

    // это моё решение...
    /*static boolean isAnagram(String s, String t){
        boolean flag = false;
        int origin = s.length();
        int check = t.length();
        int count = 0;

        if (origin == check){
            char[] a = s.toCharArray();
            char[] b = t.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            for (int i = 0; i < origin; i++) {
                if (a[i]==b[i]) count++;
            }
        }
        if (origin == count) flag = true;

        return flag;
    }*/


    // это решение умных людей
    static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;

        int[] alphabet = new int[26];

        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
            alphabet[t.charAt(i) - 'a']--;
        }
        for (int n: alphabet) if (n != 0) return false;

        return true;
    }

    public static void main(String[] args) {
        boolean flag = isAnagram("rat","car");
        System.out.println(flag);
    }

}
