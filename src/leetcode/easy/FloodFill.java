package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {

    /**
     * You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
     *
     * To perform a flood fill:
     *
     * Begin with the starting pixel and change its color to color.
     * Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
     * Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
     * The process stops when there are no more adjacent pixels of the original color to update.
     * Return the modified image after performing the flood fill.
     *
     * Example 1:
     *
     * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
     * Output: [[2,2,2],[2,2,0],[2,0,1]]
     *
     * Example 2:
     *
     * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
     * Output: [[0,0,0],[0,0,0]]
     */

     static class Pair {
        int row, col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int[][] floodFillBFS(int[][] image, int sr, int sc, int color) {
        int n = image.length, m = image[0].length;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(sr, sc));

        int[][] directions = { {0,1}, {0,-1}, {1,0}, {-1,0}};

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int row = pair.row, col = pair.col;

            if (image[row][col] == color) continue;

            for (int i = 0; i < directions.length; i++) {
                int[] dir = directions[i];
                int newRow = row + dir[0], newCol = col + dir[1];

                if (newRow >= 0 && newCol >= 0
                && newRow < n && newCol < m
                && image[newRow][newCol] == image[row][col]) {
                    queue.add(new Pair(newRow, newCol));
                }
            }
            image[row][col] = color;
        }
        return image;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image == null || image.length == 0) {
            return image;
        }
        dfs(image, image[sr][sc], color, sr, sc);
        return image;
    }

    private static void dfs(int[][] image, int originalColor, int newColor, int row, int col) {
         int rowLength = image.length, colLength = image[0].length;
         if (row < 0 || col < 0 || row >= rowLength || col >= colLength || image[row][col] == newColor || image[row][col] != originalColor) return;

         image[row][col] = newColor;
         dfs(image, originalColor, newColor, row + 1, col);
         dfs(image, originalColor, newColor, row - 1, col);
         dfs(image, originalColor, newColor, row, col + 1);
         dfs(image, originalColor, newColor, row, col - 1);
    }

    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,0,0}};
        floodFill(image, 1, 0, 2);
    }
}
