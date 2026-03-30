package scaler.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static class Pair {
        int row;
        int col;
        int time;
        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static int solve(int[][] A) {
        int freshOranges = 0;
        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                } else if (A[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };
        int time = 0;
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            time = pair.time;
            int currRow = pair.row, currCol = pair.col;

            for (int i = 0; i < directions.length; i++) {
                int newRow = currRow + directions[i][0];
                int newCol = currCol + directions[i][1];

                if (newRow >= 0 && newCol >= 0
                && newRow < A.length && newCol < A[0].length
                && A[newRow][newCol] == 1) {
                    A[newRow][newCol] = 2;
                    queue.add(new Pair(newRow, newCol, time + 1));
                    freshOranges--;
                }
            }
        }

        if (freshOranges > 0) return -1;

        return time;
    }

    public static void main(String[] args) {
        assert 4 == solve(new int[][]{ {2, 1, 1}, {1, 1, 0}, {0, 1, 1} });
        assert -1 == solve(new int[][]{ {2, 1, 1}, {0, 1, 1}, {1, 0, 1} });
    }
}
