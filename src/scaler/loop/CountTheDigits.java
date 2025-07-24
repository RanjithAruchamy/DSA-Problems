package scaler.loop;

import java.util.Scanner;

public class CountTheDigits {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        /*0
        156496
        816526
        161147*/
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int i = 1; i <= t; i++) {
            int n = scan.nextInt();

            if (n == 0) {
                System.out.println(1);
                continue;
            }

            int quotient = n;
            int digits = 0;
            while(quotient > 0) {
                quotient = quotient / 10;
                digits++;
            }
            System.out.println(digits);
        }
    }
}
