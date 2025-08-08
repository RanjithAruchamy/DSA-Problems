package scaler.arrays;

import java.util.Scanner;

public class SumTheArray {

    public static void main(String[] args) {
        /**
         * I/P: 5 1 2 3 4 5
         *
         * O/P: 15
         * */
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            arr[i] = scan.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < length; i ++) {
            sum += arr[i];
        }
        System.out.print(sum);

    }
}
