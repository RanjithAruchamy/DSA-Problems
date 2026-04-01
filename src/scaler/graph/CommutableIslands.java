package scaler.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CommutableIslands {

    public static class Pair {
        int node;
        int weight;
        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static class Graph {
        int node;
        int weight;
        public Graph(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int solve(int A, int[][] B) {

        ArrayList<Graph>[] adjacencyList = generateAdjacencyList(A, B);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(ob -> ob.weight));
        pq.add(new Pair(1, 0));

        int[] vis = new int[A + 1];

        int minimumCost = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if (vis[pair.node] == 0)
                minimumCost += pair.weight;
            vis[pair.node] = 1;

            for (Graph graph : adjacencyList[pair.node]) {
                if (vis[graph.node] == 0) {
                    pq.add(new Pair(graph.node, graph.weight));
                }
            }
        }

        return minimumCost;
    }

    private static ArrayList<Graph>[] generateAdjacencyList(int A, int[][] B) {
        ArrayList<Graph>[] adjacencyList = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1], weight = B[i][2];
            adjacencyList[u].add(new Graph(v, weight));
            adjacencyList[v].add(new Graph(u, weight));
        }
        return adjacencyList;
    }


    public static void main(String[] args) {
//        assert 6 == solve(4, new int[][]{ {1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10} });
        assert 6 == solve(4, new int[][]{ {1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3} });
    }
}
