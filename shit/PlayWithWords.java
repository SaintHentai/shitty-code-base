package com.company;

public class PlayWithWords {
    private static int[][] iterativeCalculatePalindromes(char[] word) {
        int wordLength = word.length;
        int[][] dp = new int[wordLength][wordLength];

        //создание пространства двумерного массива под слово
        for (int index = 0; index < wordLength; index++) {
            dp[index][index] = 1;
        }

        //запись слова в дмуверный массив
        for (int row = wordLength - 1; row > -1; row--) {
            for(int column = row + 1; column < wordLength; column++) {
                if (word[row] == word[column]) {
                    // сохраняем индексы пар которые прошли проверку
                    dp[row][column] = 2 + ((row + 1 <= column -1) ? dp[row + 1][column -1] : 0);
                } else {
                    dp[row][column] = Math.max(dp[row+1][column], dp[row][column -1]);
                }
            }
        }
        return dp;
    }

    private static int findMax(int[][] dp) {
        int max = 0;
        int length = dp.length;
        for (int row = 0; row < length - 1; row++) {
            for (int column = row; column < length - 1; column++) {
                max = Math.max(max, dp[row][column] * dp[column + 1][length - 1]);
            }
        }
        return max;
    }

    public static int playWithWords(String s){
        int res = 0;
        char[] word = s.toCharArray();
        int dp[][] = iterativeCalculatePalindromes(word);
        res = findMax(dp);

        return res;
    }

    public static void main(String[] args) {
        String str = "eeegeeksforskeeggeeks";
        System.out.println(playWithWords(str));
    }
}
