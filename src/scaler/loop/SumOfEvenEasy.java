package scaler.loop;

import java.util.Scanner;

public class SumOfEvenEasy {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int sum = 0;
        int i = 2;

        while(i <= a) {
            sum += i;
            i += 2;
        }

        System.out.print(sum);
    }
}
