package scaler.ifelse;

import java.util.Scanner;

public class DivisibleByTwoNumbers {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        if (input %5 == 0 && input %11 == 0) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
