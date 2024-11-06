package com.company;

import java.util.ArrayList;
import java.util.List;

public class BeautifulTriplets {

    static int beautifulTriples(int d, List<Integer> arr){
        int result = 0;

        System.out.println(arr);
        for (int i = 0; i < arr.size(); i++)
            if (arr.contains(arr.get(i) + d) && arr.contains(arr.get(i) + 2 * d)){
                System.out.println(arr.get(i) + " + " + d + " | " + arr.get(i) + " + " + 2 * d);
                result++;
            }

        return result;
    }

    public static void main(String[] args) {
        int d = 1;
        int[] a = {2,2,3,4,5};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++){
            list.add(a[i]);
        }
        System.out.println(beautifulTriples(d,list));
    }

}
