package com.company;

import java.util.ArrayList;
import java.util.List;

public class PDFViewer {

    static int desingerPdfViewer(List<Integer> list, String word){
        int res;
        char[] ch = word.toCharArray();
        ArrayList<Integer> save = new ArrayList<>();
        for (char c: ch) {
            int temp = c;
            int temp_integer = 96;
            if (temp <=122 & temp>=97){
                save.add(list.get(temp-temp_integer-1));
            }
        }
        int max = 0;
        for (int i = 0; i < save.size(); i++) {
            if (max < save.get(i)){
                max = save.get(i);
            }
        }
        res = max * word.length();

        return res;
    }

    public static void main(String[] args) {
        String str = "1 3 1 3 1 4 1 3 2 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5 5";
        String[] arr = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        int res = desingerPdfViewer(list,"abc");
        System.out.println(res);
    }

}
