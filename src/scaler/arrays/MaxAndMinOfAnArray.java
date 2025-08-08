package scaler.arrays;

import java.util.Scanner;

public class MaxAndMinOfAnArray {

    public static void main(String[] args) {
        /**
         * I/P:     5 1 2 3 4 5
         * O/P:     5 1
         */
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            arr[i] = scan.nextInt();
        }

        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < length; i ++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.print(max + " " + min);
    }
}
