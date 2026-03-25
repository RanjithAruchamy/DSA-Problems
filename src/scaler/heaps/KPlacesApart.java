package scaler.heaps;

import util.Converter;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KPlacesApart {

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= B; i++) {
            pq.add(A.get(i));
        }

        for (int i = B + 1; i < A.size(); i++) {
            output.add(pq.remove());
            pq.add(A.get(i));
        }

        while (pq.size() > 0) {
            output.add(pq.remove());
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> inputA = Converter.convertToArrayList(new int[] {1,40,2,3});
        ArrayList<Integer> inputB = Converter.convertToArrayList(new int[] {2,1,17,10,21,95});

        ArrayList<Integer> outputA = Converter.convertToArrayList(new int[] {1, 2, 3, 40});
        ArrayList<Integer> outputB = Converter.convertToArrayList(new int[] {1, 2, 10, 17, 21, 95});

        assert outputA.equals(solve(inputA, 2));
        assert outputB.equals(solve(inputB, 2));

    }
}
