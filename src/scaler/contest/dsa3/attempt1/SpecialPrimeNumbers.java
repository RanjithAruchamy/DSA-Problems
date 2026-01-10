package scaler.contest.dsa3.attempt1;

import java.util.ArrayList;

public class SpecialPrimeNumbers {

    /**
     * Given an Integer A, your task is to find the number of prime numbers less than or equal to A where the sum of the
     * digits of the prime number is also a prime number.
     *
     * Input 1: A = 10
     * Input 2: A = 30
     *
     * Output 1: 4
     * Output 2: 7
     */

    public static int countSpecialPrimes(int A) {
        int[] primeNumbers = new int[A + 1];
        primeNumbers[0] = 1;
        primeNumbers[1] = 1;
        for (int i = 2; i*i <= A; i++) {
            if (primeNumbers[i] == 0) {
                for (int j = i*i; j <= A; j+=i) {
                    primeNumbers[j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (primeNumbers[i] == 0) {
                int sumOfDigits = getSumOfDigits(i);
                if (primeNumbers[sumOfDigits] == 0) count++;
            }
        }
        return count;
    }

    private static int getSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countSpecialPrimes(10));
    }
}
