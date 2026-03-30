package scaler.graph;

import java.util.ArrayList;

public class PathInDirectedGraph {

    public static int solve(int A, int[][] B) {
        int[] visited = new int[A + 1];

        ArrayList<Integer>[] graph = generateAdjacencyList(A, B);

        return isPathExist(graph, 1, visited, A) ? 1 : 0;
    }

    private static ArrayList<Integer>[] generateAdjacencyList(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 0; i < A + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1];
            graph[u].add(v);
        }
        return graph;
    }

    private static boolean isPathExist(ArrayList<Integer>[] graph, int src, int[] vis, int A) {
        if (src == A) return true;

        vis[src] = 1;

        for (Integer node : graph[src]) {
            if (vis[node] == 0) {
                if (isPathExist(graph, node, vis, A)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        assert 0 == solve(5, new int[][]{ {1,2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} });
        assert 1 == solve(5, new int[][]{ {1,2}, {2,3}, {3,4}, {4,5} });
    }
}
