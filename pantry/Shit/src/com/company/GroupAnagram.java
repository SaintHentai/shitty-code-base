package com.company;

import java.util.*;

public class GroupAnagram {

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

    static List<List<String>> groupAnagrams(String[] strs){

        Map<String, List<String>> hm = new HashMap<>();
        for (String s: strs) {

            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(s);
        }

        return new ArrayList<>(hm.values());
    }

    public static void main(String[] args) {
        String[] str  = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> main = groupAnagrams(str);

        System.out.println(main);
    }

}
