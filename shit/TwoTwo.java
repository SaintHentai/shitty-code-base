package com.company;

import java.math.BigInteger;
import java.util.HashSet;

public class TwoTwo {

    /*static HashSet<String> set;

    static {
        set = new HashSet<>();
        int n = 800;
        set.add("1");
        for (int i = 0; i <= n - 1; ++i) {
            set.add(BigInteger.ONE.shiftLeft(i).toString());
        }
    }

    static int twoTwo(String s){
        int count = 0;
        for (int i = 0; i < s.length();i++){
            if (s.charAt(i)=='0') continue;
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.substring(i,j+1))){
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }*/


    static class Trie {
        boolean end;
        Trie[]children;
        Trie() {
            end = false;
            children = new Trie[10];
        }
        void insert(String val) {
            if(val.length() == 0) {
                end = true;
                return;
            }
            //int index = val.charAt(0) - '0';
            int index = val.charAt(val.length() - 1) - '0';
            if(children[index] == null)
                children[index] = new Trie();
            //children[index].insert(val.substring(1));
            children[index].insert(val.substring(0, val.length() - 1));
        }
    }

    static int twoTwo(String s){
        Trie trie = new Trie();
        BigInteger x = BigInteger.ONE;
        trie.insert(x.toString());
        for(int i = 0; i < 800; ++i) {
            x = x.shiftLeft(1);
            trie.insert(x.toString());
        }
        int count = 0;
        for(int i = 0; i < s.length(); ++i) {
            Trie node = trie.children[s.charAt(i) - '0'];
            if(node == null) continue;
            if(node.end) ++count;
            for(int j = 1; j < 243; ++j) {
                if(i - j < 0) break;
                node = node.children[s.charAt(i - j) - '0'];
                if(node == null) break;
                if(node.end) ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = twoTwo("2222222");
        System.out.println(a);
    }
}
