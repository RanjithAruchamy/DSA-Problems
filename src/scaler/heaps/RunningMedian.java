package scaler.heaps;

import util.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> B = new ArrayList<>();
        ArrayList<Integer> C = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            B.add(A.get(i));
            Collections.sort(B);
            int n = i+1;
            if ( n % 2 == 0) {
                C.add(B.get(n/2 - 1));
            } else {
                C.add(B.get(n / 2));
            }
        }
        return C;
    }

    public static ArrayList<Integer> solveOptimize(ArrayList<Integer> A) {

        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer num : A) {

            if (!maxPq.isEmpty() && num > maxPq.peek()) {
                minPq.add(num);
            } else {
                maxPq.add(num);
            }

            int diff = Math.abs(maxPq.size() - minPq.size());
            if (diff > 1) balance(maxPq, minPq);

            if (minPq.size() > maxPq.size()) output.add(minPq.peek());
            else    output.add(maxPq.peek());
        }
        return output;
    }

    private static void balance(PriorityQueue<Integer> minPq, PriorityQueue<Integer> maxPq) {
        if (maxPq.size() > minPq.size()) {
            minPq.add(maxPq.remove());
        } else {
            maxPq.add(minPq.remove());
        }
    }

    public static void main(String[] args) {
//        solveOptimize(Converter.convertToArrayList(new int[] {1,2,5,4,3}));
//        solveOptimize(Converter.convertToArrayList(new int[] {59,64,10,39}));
        solveOptimize(Converter.convertToArrayList(new int[] {32,91,86,8,4,100,98,15,79,32,4,99}));
    }
}
