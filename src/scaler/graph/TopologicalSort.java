package scaler.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class TopologicalSort {

    public static int[] solve(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1];
            graph[u].add(v);
        }

        int[] dependencyCount = new int[A + 1];
        for (int i = 0; i < B.length; i++) {
            dependencyCount[B[i][1]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (dependencyCount[i] == 0) {
                pq.add(i);
            }
        }

        if (pq.isEmpty()) return new int[]{};
        int[] result = new int[A];
        int idx = 0;
        while (!pq.isEmpty()) {
            Integer node = pq.remove();

            for (Integer nbr : graph[node]) {
                dependencyCount[nbr]--;
                if (dependencyCount[nbr] == 0) {
                    pq.add(nbr);
                }
            }
            result[idx++] = node;
        }
        return result;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new int[]{5, 6, 1, 3, 4, 2}, solve(6, new int[][]{ {6,3}, {6,1}, {5,1}, {5,2}, {3,4}, {4,2} }));
        assert Arrays.equals(new int[]{}, solve(3, new int[][]{ {1,2}, {2,3}, {3,1} }));
    }
}
