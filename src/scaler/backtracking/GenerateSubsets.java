package scaler.backtracking;

import java.util.ArrayList;

public class GenerateSubsets {

    /**
     * Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.
     *
     * Input 1:
     * A = [1]
     *
     * Input 2:
     * A = [1, 2, 3]
     *
     * Output 1:
     * [
     *     []
     *     [1]
     * ]
     *
     *  Output 2:
     * [
     *  []
     *  [1]
     *  [1, 2]
     *  [1, 2, 3]
     *  [1, 3]
     *  [2]
     *  [2, 3]
     *  [3]
     * ]
     */

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> subSet = new ArrayList<>();

        generateSubsets(result, subSet, A, 0);

        return result;
    }

    private static void generateSubsets(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subSet, ArrayList<Integer> input, int index) {
        if (index == input.size()) {
            result.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(input.get(index));
        generateSubsets(result, subSet, input, index + 1);

        subSet.remove(subSet.size() - 1);
        generateSubsets(result, subSet, input, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : arr) {
            list.add(n);
        }
        System.out.println(subsets(list));
    }
}
