package scaler.loop;

import java.util.Scanner;

public class EasyPower {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int power = scan.nextInt();
        int result = num;

        for (int i = 1; i < power; i++) {
            result = result * num;
        }
        System.out.print(result);
    }
}
