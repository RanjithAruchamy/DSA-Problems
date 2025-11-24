package scaler.binarysearch;

public class MatrixSearch {

    /**
     * Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
     *
     * This matrix A has the following properties:
     *
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than or equal to the last integer of the previous row.
     * Return 1 if B is present in A, else return 0.
     *
     * NOTE: Rows are numbered from top to bottom, and columns are from left to right.
     *
     * Input 1:
     * A = [
     *       [1,   3,  5,  7]
     *       [10, 11, 16, 20]
     *       [23, 30, 34, 50]
     *     ]
     * B = 3
     *
     * Input 2:
     * A = [
     *       [5, 17, 100, 111]
     *       [119, 120, 127, 131]
     *     ]
     * B = 3
     *
     * Output 1:
     * 1
     *
     * Output 2:
     * 0
     */

    public int searchMatrix(int[][] A, int B) {
        int row = 0, column = A[0].length - 1;

        while (row < A.length && column >= 0) {
            if (A[row][column] == B) {
                return 1;
            } else if (A[row][column] > B) {
                column--;
            } else {
                row++;
            }
        }
        return 0;
    }
}
