package com.company;

import java.util.*;

public class Palindrome {

    static int head = 65;

    static void init(){
        Scanner sn = new Scanner(System.in);
        String s1 = sn.nextLine();
        String s2 = sn.nextLine();
        getPalindrome(s2);
    }

    static void getPalindrome(String s){
        int startPW = head;
        int greatKey = Integer.MIN_VALUE;

        int[] alphabet = new int[26];
        HashMap<Integer, List<String>> hm = new HashMap<>();

        String center = "";
        StringBuilder sb = new StringBuilder("");

        //A ... Z, count
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'A']++;

        // A 1, B 2, C 12, D 3, U 9, Z 9 --> 9 {U, Z}
        for (int ect: alphabet) if (ect % 2 != 0 && greatKey < ect) greatKey = ect;

        // ABBC --> BCB
        for (int i = 'A'; i <= 'Z'; i++) {
            int ind = i - head;
            if (1 < alphabet[ind]) {startPW = i; break;}
        }

        for (int i = startPW; i <= 'Z'; i++) {
            int ind = i - head;
            int cur = alphabet[ind];
            String ch = String.valueOf((char) i);
            if (cur % 2 == 0 && cur != 0) {
                sb.append(ch.repeat(cur / 2));
            }
            if (cur % 2 != 0 && cur != 0) {
                if (!hm.containsKey(cur)) hm.put(cur, new ArrayList<>());
                hm.get(cur).add(ch);

                // D 3, U 9, Z 9 --> DUUUUZZZZU
                sb.append(ch.repeat((cur - 1) / 2));
                center = hm.get(greatKey).get(0);
            }
        }
        String left = sb.toString();
        String right = sb.reverse().toString();
        System.out.println(left + center + right);
    }

    public static void main(String[] args) {
        init();
    }

}
