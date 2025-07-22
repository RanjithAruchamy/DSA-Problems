package scaler.ifelse;

import java.util.Scanner;

public class ProfitOrLoss {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int costPrice = scan.nextInt();
        int sellingPrice = scan.nextInt();

        if (sellingPrice > costPrice) {
            System.out.println(1);
            System.out.println(sellingPrice - costPrice);
        } else {
            System.out.println(-1);
            System.out.println(sellingPrice - costPrice);
        }
    }
}
