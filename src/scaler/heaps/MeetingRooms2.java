package scaler.heaps;

import util.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {

    public static class CustomSort implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
            if (a.get(0) > b.get(0))    return 1;
            else if (a.get(0) < b.get(0))   return -1;
            else return 0;
        }
    }

    public static int solveBruteForce(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, new CustomSort());

        int totalOverlaps = 0;
        for (int i = 0; i < A; i++) {
            int currOverlaps = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (B.get(i).get(0) < B.get(j).get(1))  {
                    currOverlaps++;
                }
            }
            totalOverlaps = Math.max(currOverlaps, totalOverlaps);
        }
        return totalOverlaps + 1;
    }

    public static int solveHeap(int A, ArrayList<ArrayList<Integer>> B) {
        Collections.sort(B, new CustomSort());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(B.get(0).get(1));

        for (int i = 1; i < A; i++) {
            if (B.get(i).get(0) < pq.peek()) pq.add(B.get(i).get(1));
            else {
                pq.remove();
                pq.add(B.get(i).get(1));
            }
        }
        return pq.size();
    }

    public static int solve(int A, ArrayList<ArrayList<Integer>> B) {

        int[] prefArr = new int[1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(B.get(0).get(1));

        for (int i = 1; i < A; i++) {
            if (B.get(i).get(0) < pq.peek()) pq.add(B.get(i).get(1));
            else {
                pq.remove();
                pq.add(B.get(i).get(1));
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        assert 2 == solve(3, Converter.convertToArrayList(new int[][] { {0,30}, {5,10}, {15,20} }));
        assert 1 == solve(1, Converter.convertToArrayList(new int[][] { {0,1} }));
        assert 3 == solve(5, Converter.convertToArrayList(new int[][]{ {0,4}, {2,7}, {3,9}, {10,15}, {11,16} }));
    }
}
