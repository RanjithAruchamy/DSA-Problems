package scaler.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstructionCost {

    public static class Pair {
        int node;
        int dist;
        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static class Graph {
        int node;
        int dist;
        public Graph(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }


    public static int solve(int A, int[][] B) {
        if (B.length == 0) return 0;
        int dist = 0, mod = 1000000007;

        ArrayList<Graph>[] adjacencyList = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0], v = B[i][1], distance = B[i][2];
            adjacencyList[u].add(new Graph(v, distance));
            adjacencyList[v].add(new Graph(u, distance));
        }
        
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(ob -> ob.dist));
        priorityQueue.add(new Pair(B[0][0], 0));
        
        int[] vis = new int[A + 1];
        
        while (!priorityQueue.isEmpty()) {
            Pair pair = priorityQueue.remove();

            for (Graph nbr : adjacencyList[pair.node]) {
                if (vis[nbr.node] == 0) {
                    priorityQueue.add(new Pair(nbr.node, nbr.dist));
                }
            }
            if (vis[pair.node] == 0) dist += pair.dist;
            vis[pair.node] = 1;
            dist = dist % mod;
        }
        return dist;
    }

    public static void main(String[] args) {
        assert 9 == solve(3, new int[][]{ {1, 2, 14}, {2, 3, 7}, {3, 1, 2} });
        assert 37 == solve(3, new int[][]{ {1, 2, 20}, {2, 3, 17} });
    }
}
