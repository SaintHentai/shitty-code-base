package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciBigNumberModule {

    static BigInteger fibNum(long n) {

        BigInteger first = BigInteger.valueOf(0);
        BigInteger second = BigInteger.valueOf(1);
        BigInteger temp;

        if (n==0) return first;

        else {
            for (int i = 2; i <= n; i++) {
                temp = first.add(second);
                first = second;
                second = temp;
            }
            return second;
        }
    }

    public static long getPisano(int m) {

        long prev = 0;
        long curr = 1;
        long res = 0;

        if (m==0) return prev;
        else if (m==1) return curr;
        else {
            for (int i = 0; i < 6 * m; i++) {
                long temp;
                temp = curr;
                curr = (prev + curr) % m;
                prev = temp;

                if (prev == 0 && curr == 1) {
                    res = i + 1;
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        long a = sn.nextLong();
        int b = sn.nextInt();
        BigInteger m = BigInteger.valueOf(b);
        long pisano = getPisano(b);

        if (pisano != 0) {
            BigInteger answer = fibNum(a % pisano).mod(m);
            System.out.println(answer);
        }
        else
            System.out.println(fibNum(a).mod(m));
    }

}
