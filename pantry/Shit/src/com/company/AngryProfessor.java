package com.company;

import java.util.ArrayList;

public class AngryProfessor {

    static String angryProfessor(int nStudent, ArrayList<Integer> grade){
        String res = null;
        int count = 0;

        for (int student: grade) {
            if (student <= 0)
                count++;

            if (nStudent<=count){
                res = "YES";
            }else
                res = "NO";
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(-2);
        arr.add(-1);
        arr.add(2);
        arr.add(6);
        arr.add(2);
        arr.add(1);
        System.out.println(angryProfessor(3,arr));
    }

}
