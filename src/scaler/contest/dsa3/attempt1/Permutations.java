package scaler.contest.dsa3.attempt1;

import java.util.ArrayList;

public class Permutations {

    /**
     * Given an integer array A of size N denoting collection of numbers , return all possible permutations.
     *
     * NOTE:
     * No two entries in the permutation sequence should be the same.
     * For the purpose of this problem, assume that all the numbers in the collection are unique.
     * Return the answer in any order
     *
     * Input:
     * A = [1, 2, 3]
     *
     * Output:
     * [ [1, 2, 3]
     *   [1, 3, 2]
     *   [2, 1, 3]
     *   [2, 3, 1]
     *   [3, 1, 2]
     *   [3, 2, 1] ]
     */

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> small = new ArrayList<>();

        int[] visited = new int[A.size()];
        permute(A, ans, small, visited);

        return ans;
    }

    private static void permute(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> small, int[] visited) {
        if (small.size() == A.size()) {
            ans.add(new ArrayList<>(small));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if (visited[i] != 1) {
                visited[i] = 1;
                small.add(A.get(i));
                permute(A, ans, small, visited);
                visited[i] = 0;
                small.remove(small.size() - 1);
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
