package scaler.pattern;

import java.util.Scanner;

public class LeadingSpacesPyramid {

    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                     *
                     **
                     ***
                     ****
                     *****
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for(int i = 1; i <= num; i++) {
            for(int j = num; j > 0; j--) {
                if (j <= i) {
                    System.out.print("*");
                    continue;
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
