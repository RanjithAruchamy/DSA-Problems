package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaxAreaOfIsland {

    /**
     * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
     * The area of an island is the number of cells with a value 1 in the island.
     * Return the maximum area of an island in grid. If there is no island, return 0.
     *
     * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Output: 6
     *
     * Input: grid = [[0,0,0,0,0,0,0,0]]
     * Output: 0
     */

    class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowLength = grid.length, colLength = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    int area = bfs(grid, row, col);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int row, int col) {
        int rowLength = grid.length, colLength = grid[0].length;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(row, col));

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int area = 1;
        grid[row][col] = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int currRow = pair.row, currCol = pair.col;

            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                int newRow = currRow + dir[0], newCol = currCol + dir[1];

                if (newRow >= 0 && newCol >= 0
                && newRow < rowLength && newCol < colLength
                && grid[newRow][newCol] == 1) {

                    queue.add(new Pair(newRow, newCol));
                    grid[newRow][newCol] = 0;
                    area++;
                }

            }
        }
        return area;
    }

    private static int areaOfIsland = 0;
    public static int maxAreaOfIslandDfs(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rowLength = grid.length, colLength = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    areaOfIsland = 0;
                    dfs(grid, row, col);
                    maxArea = Math.max(areaOfIsland, maxArea);
                }
            }
        }
        return maxArea;
    }

    private static void dfs(int[][] grid, int row, int col) {
        int rowLength = grid.length - 1, colLength = grid[0].length - 1;

        if (row < 0 || col < 0
        || row > rowLength || col > colLength) return;

        if (grid[row][col] == 0) return;

        grid[row][col] = 0;
        areaOfIsland++;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        maxAreaOfIslandDfs(new int[][]{{1}});
    }
}
