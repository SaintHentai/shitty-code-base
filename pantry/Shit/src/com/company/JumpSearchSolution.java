package com.company;

import java.util.Scanner;

public class JumpSearchSolution {

    static int[] input = new int[2];
    static int[] a = {};
    static int[] b = {};

    static void init(){
        Scanner sn = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {
            input[i]  = sn.nextInt();
        }
        a = new int[input[0]];
        b = new int[input[1]];
        for (int i = 0; i < a.length; i++) {
            a[i] = sn.nextInt();
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = sn.nextInt();
        }
    }

    static int jumpSearch(int[] array, int x)
    {
        int B = (int) Math.sqrt(array.length); // вычисляем размер блока(прыжка)

        int start = 0; // начальная позиция блока
        int end = B - 1; // конечная позиция блока

        while (array[end] < x) // пока конец блока меньше искомого элемента
        {
            if (end == array.length - 1) // если дошли до конца массива, выходим
            {
                break;
            }

            start = Math.min(array.length - 1, start + B); // перемещаем начало блока вправо
            end = Math.min(array.length - 1, end + B); // перемещаем конец блока вправо
        }

        if (x > array[end]) // если искомый элемент больше, чем последний элемент блока, значит не нашли нужный элемент
        {
            return -1;
        }

        for (int i = end; i >= start; i--) // линейным поиском проходим по найденному блоку
        {
            if (array[i] == x) // если текущий элемент равен искомому, то возвращаем его индекс
            {
                return i;
            }
        }

        return -1; // если дошли до сюда значит не нашли в массиве искомый элемент
    }

    static void getResult(int[] sorted, int[] main){
        for (int cur: main) {
            if (jumpSearch(sorted,cur) == -1) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    public static void main(String[] args) {
        /*init();
        getResult(a,b);*/

        System.out.println(Math.min(18,9));
    }

}
