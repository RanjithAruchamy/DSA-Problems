package scaler.stack;

import java.util.ArrayList;

public class MaxRectangleInBinaryMatrix {

    /**
     * Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
     Example Input

     Input 1:
     A = [
     [1, 1, 1]
     [0, 1, 1]
     [1, 0, 0]
     ]

     Input 2:
     A = [
     [0, 1, 0]
     [1, 1, 1]
     ]

     Output 1:
     4

     Output 2:
     3
     */

    public static int maximalRectangle(int[][] A) {
        int rowSize = A.length, columnSize = A[0].length;

        // Convert to PrefSum Matrix
        for (int row = 0; row < rowSize; row++) {
            for (int column = 1; column < columnSize; column++) {
                if (A[row][column] != 0) {
                    A[row][column] = 1 + A[row][column - 1];
                }
            }
        }

        int area = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < columnSize; column++) {
                int height = 1, width = A[row][column];
                area = Math.max(area, height * width);

                for (int row1 = row - 1; row1 >= 0; row1--) {
                    height++;
                    width = Math.min(width, A[row1][column]);
                    area = Math.max(area, height * width);
                }
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1, 1, 1}, {0, 1, 1}, {1, 0, 0}};
        maximalRectangle(input);
    }
}
