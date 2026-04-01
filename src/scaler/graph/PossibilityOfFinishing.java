package scaler.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PossibilityOfFinishing {

    public static int solve(int A, int[] B, int[] C) {

        ArrayList<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            int u = B[i], v = C[i];
            graph[u].add(v);
        }

        int[] dependencyCount = new int[A + 1];
        for (int i = 0; i < B.length; i++) {
            dependencyCount[C[i]]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (dependencyCount[i] == 0) {
                pq.add(i);
            }
        }

        while (!pq.isEmpty()) {
            Integer course = pq.remove();

            for (Integer dependentCourse : graph[course]) {
                dependencyCount[dependentCourse]--;
                if (dependencyCount[dependentCourse] == 0) {
                    pq.add(dependentCourse);
                }
            }
        }

        for (int i = 0; i < dependencyCount.length; i++) {
            if (dependencyCount[i] > 0) return 0;
        }

        return 1;
    }

    public static void main(String[] args) {

        assert 1 == solve(3, new int[]{1,2}, new int[]{2,3});
        assert 0 == solve(2, new int[]{1,2}, new int[]{2,1});
    }
}
