package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    /**
     * You are given an m x n grid where each cell can have one of three values:
     *
     * 0 representing an empty cell,
     * 1 representing a fresh orange, or
     * 2 representing a rotten orange.
     * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
     *
     * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     *
     * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally
     */

    public int orangesRottingDirectionArray(int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                int orange = grid[row][column];

                if (orange == 2) queue.add(new int[]{row, column});
                else if (orange == 1) freshOranges++;
            }
        }

        if (freshOranges == 0) return 0;

        int[][] directions = new int[][]{ {1,0}, {-1,0}, {0,1}, {0,-1} };
        int minimumMinutes = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            boolean hasRottenThisMinute = false;

            for (int i = 0; i < queueSize; i++) {
                int[] index = queue.remove();

                for (int j = 0; j < directions.length; j++) {
                    int[] direction = directions[j];
                    int row = index[0] + direction[0], column = index[1] + direction[1];
                    if (row >= 0 && column >= 0 && row < rowLength && column < columnLength && grid[row][column] == 1) {
                        freshOranges--;
                        grid[row][column] = 2;
                        queue.add(new int[]{row, column});
                        hasRottenThisMinute = true;
                    }
                }
            }
            if (hasRottenThisMinute)    minimumMinutes++;
        }

        return freshOranges > 0 ? -1 : minimumMinutes;
    }

    public static int orangesRotting(int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrangeCount = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int column = 0; column < columnLength; column++) {
                int orange = grid[row][column];
                if (orange == 2) {
                    queue.add(new int[]{row, column});
                } else if (orange == 1) {
                    freshOrangeCount++;
                }
            }
        }

        if (freshOrangeCount == 0) return 0;

        int minimumMinutes = 0;

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            int rottenFreshOranges = 0;
            for (int i = 0; i < queueSize; i++) {
                int[] index = queue.poll();
                int row = index[0];
                int column = index[1];

                if (row > 0) {
                    row--;
                    if (isFreshOrange(row, column, grid)) {
                        rottenFreshOranges++;
                        grid[row][column] = 2;
                        queue.add(new int[]{row, column});
                    }
                    row++;
                }

                if (column > 0) {
                    column--;
                    if (isFreshOrange(row, column, grid)) {
                        rottenFreshOranges++;
                        grid[row][column] = 2;
                        queue.add(new int[]{row, column});
                    }
                    column++;
                }

                if (row < rowLength - 1) {
                    row++;
                    if (isFreshOrange(row, column, grid)) {
                        rottenFreshOranges++;
                        grid[row][column] = 2;
                        queue.add(new int[]{row, column});
                    }
                    row--;
                }

                if (column < columnLength - 1) {
                    column++;
                    if (isFreshOrange(row, column, grid)) {
                        rottenFreshOranges++;
                        grid[row][column] = 2;
                        queue.add(new int[]{row, column});
                    }
                    column--;
                }
            }
            if (rottenFreshOranges > 0) {
                freshOrangeCount -= rottenFreshOranges;
                minimumMinutes++;
            }
        }

        return freshOrangeCount > 0 ? -1 : minimumMinutes;
    }

    private static boolean isFreshOrange(int row, int column, int[][] grid) {
        return grid[row][column] == 1;
    }

    public static void main(String[] args) {
        int[][] input1 = { {2,1,1}, {1,1,0}, {0,1,1} };
        assert 4 == orangesRotting(input1);

        int[][] input2 = new int[][]{ {2,1,1}, {0,1,1}, {1,0,1} };
        assert -1 == orangesRotting(input2);
    }
}
