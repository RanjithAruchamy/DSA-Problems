package scaler.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

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

    public static int[] solve(int A, int[][] B, int C) {
        int[] distance = new int[A];
        Arrays.fill(distance, -1);

        ArrayList<Graph>[] graph = generateAdjacencyList(A, B);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(ob -> ob.weight));
        pq.add(new Pair(C, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if (distance[pair.node] == -1)
                distance[pair.node] = pair.weight;

            for (Graph nbr : graph[pair.node]) {
                if (distance[nbr.node] == -1) {
                    pq.add(new Pair(nbr.node, pair.weight + nbr.weight));
                }
            }
        }
        return distance;
    }

    private static ArrayList<Graph>[] generateAdjacencyList(int A, int[][] B) {
        ArrayList<Graph>[] graph = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1], weight = B[i][2];
            graph[u].add(new Graph(v, weight));
            graph[v].add(new Graph(u, weight));
        }
        return graph;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new int[] {7, 6, 5, 6, 0, 6}, solve(6, new int[][]{ {0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1} }, 4));
        assert Arrays.equals(new int[] {14, 18, 13, 10, 0}, solve(5, new int[][]{ {0, 3, 4}, {2, 3, 3}, {0, 1, 9}, {3, 4, 10}, {1, 3, 8} }, 4));
    }
}
