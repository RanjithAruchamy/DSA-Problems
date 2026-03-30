package scaler.graph;

import java.util.ArrayList;

public class CycleInDirectedGraph {

    public static int solve(int A, int[][] B) {
        int[] visited = new int[A + 1];
        int[] path = new int[A + 1];

        ArrayList<Integer>[] graph = generateAdjacencyList(A, B);

        for (int i = 1; i < A + 1; i++) {
            if (visited[i] == 0) {
                if (detectCycle(graph, i, visited, path)) return 1;
            }
        }

        return 0;
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

    private static boolean detectCycle(ArrayList<Integer>[] graph, int src, int[] vis, int[] path) {
        vis[src] = 1;
        path[src] = 1;

        for (Integer node : graph[src]) {
            if (path[node] == 1) return true;
            if (vis[node] == 0) {
                if (detectCycle(graph, node, vis, path)) return true;
            }
        }
        path[src] = 0;
        return false;
    }
    
    

    public static void main(String[] args) {
        assert 1 == solve(5, new int[][]{ {1,2}, {4,1}, {2,4}, {3,4}, {5,2}, {1,3} });
        assert 0 == solve(5, new int[][]{ {1,2}, {2,3}, {3,4}, {4,5} });
    }
}
