package scaler.loop;

import java.util.Scanner;

public class BankAccount2 {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner scan = new Scanner(System.in);
        long balance  = scan.nextInt();
        int numberOfOperations = scan.nextInt();

        for (int i = 1; i <= numberOfOperations; i++) {
            int operationType = scan.nextInt();
            long amount = scan.nextInt();

            if (operationType == 1) {   //ADD
                balance = balance + amount;
            } else if (operationType == 2) {    //SUBTRACT
                if (amount > balance) {
                    System.out.println("Insufficient Funds");
                } else {
                    balance = balance - amount;
                }
            }
            System.out.println(balance);
        }
    }
}
