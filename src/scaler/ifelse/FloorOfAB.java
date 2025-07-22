package scaler.ifelse;

import java.util.Scanner;

public class FloorOfAB {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int inputA = scan.nextInt();
        int inputB = scan.nextInt();

        System.out.print(inputA / inputB);
    }
}
