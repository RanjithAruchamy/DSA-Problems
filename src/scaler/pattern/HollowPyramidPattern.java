package scaler.pattern;

import java.util.Scanner;

public class HollowPyramidPattern {

    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                     **********
                     ****  ****
                     ***    ***
                     **      **
                     *        *
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {

            for (int j = num; j > 0; j--) {
                if (j <= i) {
                    System.out.print(" ");
                    continue;
                }
                System.out.print("*");
            }

            for (int j = 1; j <= num; j++) {
                if (j > i) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
