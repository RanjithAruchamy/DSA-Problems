package scaler.pattern;

import java.util.Scanner;

public class PrintNstars {

    public static void main(String[] args) {
        /**
         * Input: 5
         * Output:
                   *****
         */
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        for(int i = 0; i < num; i++) {
            System.out.print("*");
        }
    }
}
