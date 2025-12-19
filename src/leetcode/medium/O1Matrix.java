package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class O1Matrix {

    /**
     * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
     * The distance between two cells sharing a common edge is 1.
     *
     * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
     * Output: [[0,0,0],[0,1,0],[0,0,0]]
     *
     * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
     * Output: [[0,0,0],[0,1,0],[1,2,1]]
     */

    public static int[][] updateMatrix(int[][] mat) {

        int rowLength = mat.length, columnLength = mat[0].length;

        int[][] visited = new int[rowLength][columnLength];
        Queue<int[]> queue = new LinkedList<>();

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                int element = mat[row][column];
                if (element == 0) {
                    visited[row][column] = 1;
                    queue.add(new int[]{row, column});
                }
            }
        }

        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            int row = index[0];
            int column = index[1];
            for (int j = 0; j < directions.length; j++) {
                int[] direction = directions[j];
                int newRow = index[0] + direction[0];
                int newColumn = index[1] + direction[1];

                if (newRow >=0 && newRow < rowLength &&
                        newColumn >= 0 && newColumn < columnLength &&
                        visited[newRow][newColumn] == 0
                ) {
                    visited[newRow][newColumn] = 1;
                    mat[newRow][newColumn] = mat[row][column] + 1;
                    queue.add(new int[]{newRow, newColumn});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] input1 = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] output1 = {{0,0,0},{0,1,0},{0,0,0}};
        assert Arrays.deepEquals(output1, updateMatrix(input1));

        int[][] input2 = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] output2 = {{0,0,0},{0,1,0},{1,2,1}};
        assert Arrays.deepEquals(output2, updateMatrix(input2));
    }
}
