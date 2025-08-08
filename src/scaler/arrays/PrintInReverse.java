package scaler.arrays;

import java.util.Scanner;

public class PrintInReverse {

    public static void main(String[] args) {
        /**
         * I/P:
         * 5
         * 1 2 3 4 5
         * O/P:     5 4 3 2 1
         */
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            arr[i] = scan.nextInt();
        }

        for (int i = length-1; i >=0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
