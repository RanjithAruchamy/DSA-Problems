package scaler.pattern;

import java.util.Scanner;

public class TwoLineStarPattern {

    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                 *   *
                 *   *
                 *   *
                 *   *
                 *   *
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for(int i = 1; i <=num; i++) {
            System.out.print("*");
            for (int j = 2; j < num; j++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }
}
