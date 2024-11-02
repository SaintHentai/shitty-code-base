package com.company;

//1 5 10 15 9 6 2
//0 2 1
//0 1 3 2
//0 1 2 2 6 5 4 3
//1 5 15 15 9 6 2
//1 2 3 2 1 2 3 4 1

//хотел как крутой yandex прогер сделать через один while, но не фига. Гребанный while!!!
import java.util.*;

public class StaticArr {

    static void mountain(){
        ArrayList<Integer> hm = new ArrayList<>();
        Scanner sn = new Scanner(System.in);
        int size = sn.nextInt();

        for (int i = 0; i < size; i++)
            hm.add(sn.nextInt());

        int maxValue = Collections.max(hm);
        int key = hm.indexOf(maxValue);

        if (key == 0 || key + 1 == size) System.out.println("NO");
        else {
            boolean flag = true;

            for (int left = 0; left < key; left++)
                if (hm.get(left) >= hm.get(left + 1)) flag = false;

            for (int right = key; right < size - 1; right++)
                if (hm.get(right) <= hm.get(right + 1)) flag = false;

            if (flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        mountain();
    }
}
