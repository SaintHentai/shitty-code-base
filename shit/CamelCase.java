package com.company;

public class CamelCase {

    static int camelCase(String s){
        int res = 1;

        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))){
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String str = "saveChangesInTheEditor";

        System.out.println(camelCase(str));
    }

}
