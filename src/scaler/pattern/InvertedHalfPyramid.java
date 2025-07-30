package scaler.pattern;

import java.util.Scanner;

public class InvertedHalfPyramid {
    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                 *****
                 ****
                 ***
                 **
                 *
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = num; i >= 1; i--) {
            for (int j = 1; j <= num; j++) {
                if (j > i) {
                    break;
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
