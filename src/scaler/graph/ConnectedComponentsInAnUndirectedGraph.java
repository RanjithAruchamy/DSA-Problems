package scaler.graph;

import util.Converter;

import java.util.ArrayList;
import java.util.Collections;

public class ConnectedComponentsInAnUndirectedGraph {

    public static ArrayList<ArrayList<Integer>> getComponents(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] graph = generateAdjacencyList(A, B);

        int[] visited = new int[A];
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0) {
                ArrayList<Integer> connectedItems = new ArrayList<>();
                dfs(graph, connectedItems, i, visited);
                Collections.sort(connectedItems);
                output.add(connectedItems);
            }
        }

        Collections.sort(output, (ob1, ob2) -> ob1.equals(ob2) ? -1 : 1);
        return output;
    }

    private static void dfs(ArrayList<Integer>[] graph, ArrayList<Integer> connectedItems, int src, int[] visited) {
        if (visited[src] == 0) connectedItems.add(src);

        visited[src] = 1;

        ArrayList<Integer> childItems = graph[src];
        for (int i = 0; i < childItems.size(); i++) {
            if (visited[childItems.get(i)] == 0) {
                dfs(graph, connectedItems, childItems.get(i), visited);
            }
        }
    }

    private static ArrayList<Integer>[] generateAdjacencyList(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < B.size(); i++) {
            int u = B.get(i).get(0), v = B.get(i).get(1);
            adjacencyList[u].add(v);
            adjacencyList[v].add(u);
        }
        return adjacencyList;
    }

    public static void main(String[] args) {
        assert Converter.convertToArrayList(new int[][]{ {0, 1, 2}, {3, 4} }).equals(getComponents(5, Converter.convertToArrayList(new int[][]{ {0, 1}, {2,1}, {3,4} })));
        assert Converter.convertToArrayList(new int[][]{ {0, 1, 6}, {2, 3, 4}, {5} }).equals(getComponents(7, Converter.convertToArrayList(new int[][]{ {0, 1}, {6,0}, {2,4}, {2,3}, {3,4} })));
    }
}
