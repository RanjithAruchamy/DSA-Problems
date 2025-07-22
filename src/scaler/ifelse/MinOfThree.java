package scaler.ifelse;

import java.util.Scanner;

public class MinOfThree {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int numA = scan.nextInt();
        int numB = scan.nextInt();
        int numC = scan.nextInt();

        if (numA < numB && numA < numC) {
            System.out.print(numA);
        } else if (numB < numA && numB < numC) {
            System.out.print(numB);
        } else {
            System.out.print(numC);
        }
    }
}
