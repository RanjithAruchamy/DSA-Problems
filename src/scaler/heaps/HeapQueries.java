package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

import static util.Converter.convertToArrayList;

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
        /* iterate queries
        build push & pop methods
        push will push the element to the ArrayList and build a min heap
        pop will remove the min elem and fix the minHeap, it returns -1 if the array is empty
        */

        ArrayList<Integer> pq = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            int p = A.get(i).get(0), q = A.get(i).get(1);

            if (p == 2) push(pq, q);
            else if (p == 1) output.add(pop(pq));
        }
        return output;
    }

    private static void push(ArrayList<Integer> pq, int elem) {
        pq.add(elem);
        int index = pq.size() - 1;
        int parent = (index - 1) / 2;

        while (index > 0 && pq.get(parent) > pq.get(index)) {
            int temp = pq.get(parent);
            pq.set(parent, pq.get(index));
            pq.set(index, temp);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private static int pop(ArrayList<Integer> pq) {
        if (pq.size() == 0) return -1;

        int n = pq.size() - 1;
        int firstElem = pq.get(0), lastElem = pq.get(n);
        pq.set(0, lastElem);
        pq.remove(n);

        downHeapify(pq, 0);

        return firstElem;
    }

    private static void downHeapify(ArrayList<Integer> A, int parent) {

        while ((2 * parent) + 1 < A.size()) {
            int leftChild = (2 * parent) + 1, rightChild = (2 * parent) + 2;
            int leftElem = A.get(leftChild), parentElem = A.get(parent);

            int minElem;
            if (rightChild < A.size()) {
                int rightElem = A.get(rightChild);
                minElem = Math.min(parentElem, Math.min(leftElem, rightElem));
            } else {
                minElem = Math.min(parentElem, leftElem);
            }

            if (minElem == parentElem) return;
            else if (minElem == leftElem) {
                swap(A, leftChild, parent);
                parent = leftChild;
            } else {
                swap(A, rightChild, parent);
                parent = rightChild;
            }
        }
    }

    private static void swap(ArrayList<Integer> A, int indexA, int indexB) {
        int temp = A.get(indexA);
        A.set(indexA, A.get(indexB));
        A.set(indexB, temp);
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
}
