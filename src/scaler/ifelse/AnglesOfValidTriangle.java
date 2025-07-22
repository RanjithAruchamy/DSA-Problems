package scaler.ifelse;

import java.util.Scanner;

public class AnglesOfValidTriangle {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int inputA = scan.nextInt();
        int inputB = scan.nextInt();
        int inputC = scan.nextInt();
        int sum = inputA + inputB + inputC;

        if (sum == 180) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
    }
}
