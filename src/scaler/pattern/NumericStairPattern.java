package scaler.pattern;

import java.util.Scanner;

public class NumericStairPattern {

    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                 1
                 1 2
                 1 2 3
                 1 2 3 4
                 1 2 3 4 5
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
                if (j < i) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
