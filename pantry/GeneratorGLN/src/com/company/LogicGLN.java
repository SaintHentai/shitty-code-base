package com.company;

import java.util.ArrayList;

public class LogicGLN {

    private int input; //количество глнов

    private int wall; //стена которая разделяет между собой глны

    private final int base = 10; // модуль

    private final ArrayList<Integer> mainList = new ArrayList<>(); //гланвый лист где храниться глны

    public LogicGLN(int input, String strWall) { //вход, передача количества и стен
        this.input = input;
        wall = Integer.parseInt(strWall);
    }

    private int getFourNumbers(){ // генерация 4-рех значного числа
        int range = 10000;
        int fourNumbers = (int) (Math.random()* ++range);
        if (fourNumbers>999){
            return fourNumbers;
        }else{
            fourNumbers = getFourNumbers();
        }
        return fourNumbers;
    }

    private int calculateGLN(ArrayList<Integer> arr){ //создание 13-ого числа для глна
        int evenSixNum = 0 , oddSixNum = 0;
        int x13;
        for (int i = 1; i <= 6; i++) {
            oddSixNum = oddSixNum + arr.get(2*i - 2);
            evenSixNum = evenSixNum + arr.get(2*i - 1);
        }
        x13 = (oddSixNum + evenSixNum * 3) % base;
        x13 = base - x13;
        return x13 == base ? 0 : x13;
    }

    private void getListGln(){ //запись глнов в главный массив
        int countGln = input;
        for (int i = 0; i < countGln; i++) {
            int headGln = 98798700;
            int tailGln = getFourNumbers();
            final ArrayList<Integer> partOne = new ArrayList<>();
            final ArrayList<Integer> partTwo = new ArrayList<>();
            final ArrayList<Integer> result = new ArrayList<>();
            while (headGln !=0){
                int nextElement = 0;
                partOne.add(nextElement,(headGln % base));
                nextElement++;
                headGln = headGln / base;
            }
            while (tailGln != 0) {
                int nextElement = 0;
                partTwo.add(nextElement,(tailGln % base));
                nextElement++;
                tailGln = tailGln / base;
            }
            result.addAll(partOne);
            result.addAll(partTwo);
            result.add(calculateGLN(result));
            result.add(wall);
            mainList.addAll(result);
        }
    }

    public String getArrStr(){ // оборачивание главного в массива в строку
        String s;
        getListGln();
        StringBuilder out = new StringBuilder();
        for (Object o: mainList) {
            out.append(o.toString());
        }
        s = String.valueOf(out);
        return s;
    }
}