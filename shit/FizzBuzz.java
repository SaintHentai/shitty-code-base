package com.company;

public class FizzBuzz {

    static String fizzBuzz(int n){
        int tail = n;
        int head = 1;
        String result = "";
        while (head <= tail){
            if (head % 3 == 0){
                result += "Fizz";
            }
            if (head % 5 == 0){
                result += "Buzz";
            }
            else
                result += " " + head +" ";
            head++;
        }
        return result;
    }

    static String preFizzBuzz(int n){
        String res = "";
        if (n % 3 == 0){
            res += "Fizz";
        }
        if (n % 5 == 0){
            res += "Buzz";
        }
        return res;
    }

    public static void main(String[] args) {
        String[] a = fizzBuzz(15).split(" ");
        for (int i = 0; i < a.length; i++) {
            if (!a[i].isEmpty())
                System.out.print(a[i]+" ");
        }
        System.out.println();
        String b = preFizzBuzz(15);
        System.out.println(b);
    }

}
