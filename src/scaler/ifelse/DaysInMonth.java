package scaler.ifelse;

import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        if (num == 2) {
            System.out.print(28);
        } else if (num <= 7) {
            if (num %2 == 0) {
                System.out.print(30);
            } else {
                System.out.print(31);
            }
        } else if (num >= 8) {
            if (num %2 != 0) {
                System.out.print(30);
            } else {
                System.out.print(31);
            }
        }
    }
}
