package com.company;

public class HallowenGames {

    static int howManyGames(int init_price, int decresing_price, int min_price, int max_price){
        int next_price = init_price;
        int count = 0;
        while (true) {
            if (max_price < next_price){
                break;
            }
            count++;
            max_price -= next_price;
            next_price = next_price - decresing_price;
            if (next_price < min_price)
                next_price = min_price;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(howManyGames(20,3,6,80));
    }
}
