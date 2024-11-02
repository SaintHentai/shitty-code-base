package com.company;

import java.util.ArrayList;
import java.util.List;

public class SubArrays {

    public static List<Long> findSum(List<Integer> numbers, List<List<Integer>> queries) {

        List<Long> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++){

            int head = queries.get(i).get(0) - 1;
            int tail = queries.get(i).get(1) - 1;
            int var = queries.get(i).get(2);
            long sum = 0;

            if (head == tail) {
                if (numbers.get(tail)==0){
                    sum = var;
                    result.add(sum);
                }
            } else {
                for (int j = head; j <= tail; j++) {
                    sum = sum + numbers.get(j);
                    if (numbers.get(j)==0){
                        sum = sum + var;
                    }
                }
                result.add(sum);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        List<List<Integer>> q = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(2);
        a.add(20);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(10);
        q.add(a);
        q.add(b);
        List<Integer> num = new ArrayList<>();
        num.add(-5);
        num.add(0);

        System.out.println(findSum(num,q));
    }
}
