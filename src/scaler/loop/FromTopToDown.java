package scaler.loop;

import java.util.Scanner;

public class FromTopToDown {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i = 1;

        while(i <= n) {
            System.out.print(i + " ");
            i ++;
        }
    }
}
