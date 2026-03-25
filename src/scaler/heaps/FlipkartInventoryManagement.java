package scaler.heaps;

import util.Converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FlipkartInventoryManagement {

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> subArr = new ArrayList<>();
            subArr.add(A.get(i));
            subArr.add(B.get(i));
            input.add(subArr);
        }

        Collections.sort(input, new CustomSort());

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> c : input) {
            int expiry = c.get(0);
            int profit = c.get(1);

            if (expiry > time) {
                pq.add(profit);
                time++;
            } else {
                if (profit > pq.peek()) {
                    pq.remove();
                    pq.add(profit);
                }
            }
        }

        int profit = 0;
        while (pq.size() > 0) {
            profit += pq.remove();
        }
        return profit;
    }

    public static class CustomSort implements Comparator<ArrayList<Integer>> {
        public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
            if (a.get(0) > b.get(0))    return 1;
            else if (a.get(0) < b.get(0)) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(solve(Converter.convertToArrayList(new int[]{1, 3, 2, 3, 3}), Converter.convertToArrayList(new int[]{5, 6, 1, 3, 9})));
        System.out.println(solve(Converter.convertToArrayList(new int[]{3, 8, 7, 5}), Converter.convertToArrayList(new int[]{3, 1, 7, 19})));
    }
}
