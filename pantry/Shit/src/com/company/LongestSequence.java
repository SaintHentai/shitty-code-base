package com.company;

import java.util.ArrayList;
import java.util.List;

public class LongestSequence {

    static int binSearch(int[] arr, int head, int tail, Integer key){
        int res = 0;
        while (head < tail){
            int mid = (head + tail) / 2;
            if (arr[mid] < key){
                head = mid + 1;
                res = head;
            }else {
                tail = mid;
                res = tail;
            }
        }
        return res;
    }

    static void longestIncressingSequence(List<Integer> arr){

        int[] save = new int[arr.size()];
        int len = 0;

        for (int i = 0; i < arr.size(); i++) {
            int idx = binSearch(save,0,len,arr.get(i));

            if (idx < 0 ){
                System.out.println(idx);
                idx =- (idx + 1);
            }

            save[idx] = arr.get(i);

            if (idx==len)
                len++;
        }

        /*for (int i = 0; i < save.length; i++)
            save[i] = 1;

        for (int i = 1; i < arr.size(); i++)
            for (int j = 0; j < i; j++)
                if (arr.get(j) < arr.get(i) && save[i] < save[j] + 1)
                    save[i] = save[j] + 1;

        for (int i = 0; i < save.length; i++)
            if (len < save[i])
                len = save[i];*/

        System.out.println(len);
    }

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(4);
        arr.add(-1);
        arr.add(0);
        arr.add(6);
        arr.add(2);
        arr.add(3);
        longestIncressingSequence(arr);
    }
}
