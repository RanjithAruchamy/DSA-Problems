package scaler.pattern;

import java.util.Scanner;

public class StairPattern {
    public static void main(String[] args) {
        /**
        * Input: 6
        * Output:
                 *
                 **
                 ***
                 ****
                 *****
                 ******

        * */

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 1; i <= num; i++) {
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
