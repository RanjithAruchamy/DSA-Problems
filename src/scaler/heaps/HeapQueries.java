package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class HeapQueries {

    /**
     * You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:
     *
     * P = 1, Q = -1 : Pop the minimum element from the heap.
     * P = 2, 1 <= Q <= 109 : Insert Q into the heap.
     *
     * Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.
     *
     * Input 1:
     * A = [[1, -1], [2, 2], [2, 1], [1, -1]]
     * Input 2:
     * A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]
     *
     * Output 1:
     * [-1, 1]
     * Output 2:
     * [1, 3]
     */

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            int p = A.get(i).get(0), q = A.get(i).get(1);

            if (p == 1) {
                if (priorityQueue.isEmpty())    result.add(-1);
                else result.add(priorityQueue.remove());
            } else {
                priorityQueue.add(q);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> output1 = new ArrayList<>();
        output1.add(-1);
        output1.add(1);
        ArrayList<Integer> output2 = new ArrayList<>();
        output2.add(1);
        output2.add(3);

        assert output1.equals(solve(convertToArrayList(new int[][]{ {1,-1}, {2,2}, {2,1}, {1,-1} })));
        assert output2.equals(solve(convertToArrayList(new int[][]{ {2,5}, {2,3}, {2,1}, {1,-1}, {1,-1} })));
    }

    public static ArrayList<ArrayList<Integer>> convertToArrayList(int[][] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < arr[i].length; j++) {
                row.add(arr[i][j]);
            }
            result.add(row);
        }
        return result;
    }
}
