package scaler.pattern;

import java.util.Scanner;

public class PrintAMatrixOfStars {

    public static void main(String[] args) {
        /**
         * Input:
         *      4
         *      6
         * Output:
                 ******
                 ******
                 ******
                 ******
         */
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
