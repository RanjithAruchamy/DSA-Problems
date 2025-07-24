package scaler.loop;

import java.util.Scanner;

public class PalindromicInteger {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int reverseNum = reverseNum(num);

        if (num == reverseNum) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }

    private static int reverseNum(int num) {
        int reversedNum = 0;
        while (num > 0) {
            reversedNum = reversedNum * 10 + (num % 10);
            num = num / 10;
        }
        return reversedNum;
    }
}
