package leetcode.medium;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    /**
     * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * Output: 1
     * Example 2:
     *
     * Input: grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * Output: 3
     */


    public int numIslandsBfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rowLength = grid.length, columnLength = grid[0].length;
        int isLands = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (grid[row][col] == '1') {
                    isLands++;
                    bfs(grid, row, col);
                }
            }
        }
        return isLands;
    }

    private void bfs(char[][] grid, int originalRow, int originalCol) {
        int columnLength = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(originalRow * columnLength + originalCol);

        int[][] directions = { {1,0}, {-1,0}, {0,1}, {0,-1}};
        while (!queue.isEmpty()) {
            Integer index = queue.remove();
            int row = index / columnLength;
            int col = index % columnLength;
            grid[row][col] = '0';

            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                int newRow = row + dir[0], newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0
                        && newRow < grid.length && newCol < grid[0].length
                        && grid[newRow][newCol] == '1') {
                    grid[newRow][newCol] = '0';
                    queue.add(newRow * columnLength + newCol);
                }
            }
        }
    }

    public int numIslandsDfs(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rowLength = grid.length, columnLength = grid[0].length;
        int isLands = 0;

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < columnLength; col++) {
                if (grid[row][col] == '1') {
                    isLands++;
                    dfs(grid, row, col);
                }
            }
        }
        return isLands;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }

}
