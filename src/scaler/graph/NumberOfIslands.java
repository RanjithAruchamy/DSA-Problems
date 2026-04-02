package scaler.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NumberOfIslands {

    public static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int solve(int[][] A) {

        int islandCount = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    islandCount++;
                    dfs(i, j, A);
                }
            }
        }

        return islandCount;
    }

    public static void bfs(int row, int col, int[][] A) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        int[][] directions = { {0,1}, {0,-1}, {-1,0}, {1,0}, {-1,-1}, {1,1}, {-1,1}, {1,-1} };

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            A[pair.row][pair.col] = 2;

            for (int i = 0; i < directions.length; i++) {
                int newRow = pair.row + directions[i][0], newCol = pair.col + directions[i][1];
                if (newRow >= 0 && newCol >= 0 &&
                        newRow < A.length && newCol < A[0].length && A[newRow][newCol] == 1) {
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
    }

    public static void dfs(int i, int j, int[][] A) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1) {
            return;
        }

        A[i][j] = 2;

        dfs(i, j+1, A);
        dfs(i, j-1, A);
        dfs(i+1, j, A);
        dfs(i-1, j, A);
        dfs(i-1, j-1, A);
        dfs(i+1, j+1, A);
        dfs(i-1, j+1, A);
        dfs(i+1, j-1, A);
    }

    public static void main(String[] args) {
        assert 2 == solve(new int[][]{ {0, 1, 0}, {0, 0, 1}, {1, 0, 0} });
        assert 5 == solve(new int[][]{ {1, 1, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1} });
    }
}
