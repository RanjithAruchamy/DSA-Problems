package scaler.ifelse;

import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int balance = scan.nextInt();
        int type = scan.nextInt();
        int amount = scan.nextInt();

        if (amount > balance) {
            System.out.print("Insufficient Funds");
        }

        if (type == 1) {
            System.out.print(balance + amount);
        } else if (type == 2) {
            System.out.print(balance - amount);
        }
    }
}
