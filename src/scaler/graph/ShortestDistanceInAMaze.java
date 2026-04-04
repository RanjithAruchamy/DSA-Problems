package scaler.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInAMaze {

    private static class Pair {
        int row;
        int col;
        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int solve(int[][] A, int[] B, int[] C) {
        int[][] distance = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            Arrays.fill(distance[i], -1);
        }
        distance[B[0]][B[1]] = 0;

        int[][] directions = { {0,1}, {-1,0}, {1,0}, {0,-1} };
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(B[0], B[1]));

        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int currRow = pair.row;
            int currCol = pair.col;

            for (int i = 0; i < directions.length; i++) {
                int newRow = currRow + directions[i][0];
                int newCol = currCol + directions[i][1];
                int currDistance = distance[currRow][currCol];

                while (newRow >= 0 && newCol >= 0 && newRow < A.length && newCol < A[0].length && A[newRow][newCol] == 0) {
                    newRow = newRow + directions[i][0];
                    newCol = newCol + directions[i][1];
                    currDistance++;
                }

                newRow = newRow - directions[i][0];
                newCol = newCol - directions[i][1];
                if (distance[newRow][newCol] == -1 || distance[newRow][newCol] > currDistance) {
                    distance[newRow][newCol] = currDistance;
                    queue.add(new Pair(newRow, newCol));
                }

            }
        }

        return distance[C[0]][C[1]];
    }

    public static void main(String[] args) {
        assert 1 == solve(new int[][]{ {0, 0}, {0, 0} }, new int[]{0, 0}, new int[]{0, 1});
        assert -1 == solve(new int[][]{ {0, 1}, {1, 0} }, new int[]{0, 0}, new int[]{1, 1});
        assert 3 == solve(new int[][]{ {1,1,0,1}, {0,0,0,1}, {1,0,0,1}, {0,0,1,0} }, new int[]{1, 1}, new int[]{2, 1});
    }
}
