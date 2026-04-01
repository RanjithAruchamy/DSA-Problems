package scaler.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AnotherBFS {

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

    public static int solve(int A, int[][] B, int C, int D) {
        ArrayList<Graph>[] graphs = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1], weight = B[i][2];
            graphs[u].add(new Graph(v, weight));
            graphs[v].add(new Graph(u, weight));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(obj -> obj.weight));
        pq.add(new Pair(C, 0));

        int[] vis = new int[A];
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if (pair.node == D) return pair.weight;
            vis[pair.node] = 1;

            for (Graph nbr : graphs[pair.node]) {
                if (vis[nbr.node] == 0) {
                    pq.add(new Pair(nbr.node, pair.weight + nbr.weight));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        assert 4 == solve(6, new int[][]{ {2, 5, 1}, {1, 3, 1}, {0, 5, 2}, {0, 2, 2}, {1, 4, 1}, {0, 1, 1} }, 3, 2);
        assert 1 == solve(2, new int[][]{ {0, 1, 1} }, 0, 1);
    }
}
