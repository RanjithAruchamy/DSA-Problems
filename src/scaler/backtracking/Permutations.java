package scaler.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /**
     * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
     *
     * NOTE:
     * No two entries in the permutation sequence should be the same.
     * For the purpose of this problem, assume that all the numbers in the collection are unique.
     * Return the answer in any order
     * WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
     * Example : next_permutations in C++ / itertools.permutations in python.
     * If you do, we will disqualify your submission retroactively and give you penalty points.
     *
     * Example Input
     * A = [1, 2, 3]
     *
     *
     * Example Output
     * [ [1, 2, 3]
     *   [1, 3, 2]
     *   [2, 1, 3]
     *   [2, 3, 1]
     *   [3, 1, 2]
     *   [3, 2, 1] ]
     */

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> permutation = new ArrayList<>();

        boolean[] visited = new boolean[A.size()];

        permutation(A, visited, permutation, ans, 0);

        return ans;
    }

    private static void permutation(ArrayList<Integer> arr, boolean[] visited, ArrayList<Integer> permutation, ArrayList<ArrayList<Integer>> ans, int index) {
        if (index == arr.size()) {
            ans.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < arr.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(arr.get(i));
                permutation(arr, visited, permutation, ans, index + 1);
                visited[i] = false;
                permutation.remove(index);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>();

        for (int n : arr) {
            list.add(n);
        }
        System.out.println(permute(list));
    }
}
