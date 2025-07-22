package scaler.ifelse;

import java.util.Scanner;

public class CodingRating {

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner scan = new Scanner(System.in);
        int rating = scan.nextInt();

        if (rating >= 2100) {
            printCategory(rating, "grand master");
        } else if (rating >= 1900) {
            printCategory(rating, "candidate master");
        } else if (rating >= 1600) {
            printCategory(rating, "expert");
        } else if (rating >= 1400) {
            printCategory(rating, "pupil");
        } else if (rating < 1400) {
            printCategory(rating, "newbie");
        }
    }

    private static void printCategory(int rating, String category) {
        if (rating % 2 == 0) {
            System.out.print(category.toUpperCase());
        } else {
            System.out.print(category.toLowerCase());
        }
    }
}
