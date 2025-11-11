package scaler.arrays.subarray;

import java.util.ArrayList;
import java.util.List;

public class MergeSortedOverlappingIntervals2 {

    /**
     * You are given a collection of intervals A in a 2-D array format, where each interval is represented by a pair of integers `[start, end]`.
     * The intervals are sorted based on their start values.
     *
     * Your task is to merge all overlapping intervals and return the resulting set of non-overlapping intervals.
     *
     * 1 <= len(A) <= 100000.
     * 1 <= A[i][0] <= A[i][1] <= 100000
     *
     * A is sorted based on the start value (A[i][0])
     *
     * InputA:
     * [ [1, 3], [2, 6], [8, 10], [15, 18] ]
     *
     * InputB:
     * [ [2, 10], [4, 9], [6, 7] ]
     *
     * OutputA:
     * [ [1, 6], [8, 10], [15, 18] ]
     *
     * OutputB:
     * [ [2, 10] ]
     */

    public static int[][] solve(int[][] A) {
        //intialize previous value
        //iterate & compare the prevValue with currValue
            // if it's overlapping then merge (replace prev value with merged value)
            // else add the prev value to ans & replace prev value with current value
        // add the last element (prev value) to the ans
        int prevValueStart = A[0][0];
        int prevValueEnd = A[0][1];
        int[][] ansArr = new int[3][2];
        for (int i = 1; i < A.length; i++) {
            int currValueStart = A[i][0], currValueEnd = A[i][1];
            if (currValueStart < prevValueEnd) {
                prevValueStart = Math.min(prevValueStart, currValueStart);
                prevValueEnd = Math.max(prevValueEnd, currValueEnd);
            } else {
                prevValueStart = currValueStart;
                prevValueEnd = currValueEnd;
            }
        }
        return ansArr;
    }

    public static List<List<Integer>> solve(List<List<Integer>> A) {
        //intialize previous value
        //iterate & compare the prevValue with currValue
        // if it's overlapping then merge (replace prev value with merged value)
        // else add the prev value to ans & replace prev value with current value
        // add the last element (prev value) to the ans
        int prevValueStart = A.getFirst().getFirst();
        int prevValueEnd =  A.getFirst().getLast();
        List<List<Integer>> ansArr = new ArrayList<>();

        for (int i = 1; i < A.size(); i++) {
            int currValueStart = A.get(i).getFirst(), currValueEnd = A.get(i).getLast();
            if (currValueStart < prevValueEnd) {
                prevValueStart = Math.min(prevValueStart, currValueStart);
                prevValueEnd = Math.max(prevValueEnd, currValueEnd);
            } else {
                ansArr.add(List.of(prevValueStart, prevValueEnd));
                prevValueStart = currValueStart;
                prevValueEnd = currValueEnd;
            }
        }

        ansArr.add(List.of(prevValueStart, prevValueEnd));
        return ansArr;
    }

    public static ArrayList<ArrayList<Integer>> solveScaler(List<List<Integer>> A) {
        int prevValueStart = A.get(0).get(0);
        int prevValueEnd =  A.get(0).get(1);
        ArrayList<ArrayList<Integer>> ansArr = new ArrayList<>();

        for (int i = 1; i < A.size(); i++) {
            int currValueStart = A.get(i).get(0), currValueEnd = A.get(i).get(1);
            if (currValueStart < prevValueEnd) {
                prevValueStart = Math.min(prevValueStart, currValueStart);
                prevValueEnd = Math.max(prevValueEnd, currValueEnd);
            } else {
                ArrayList<Integer> innerList = new ArrayList<>();
                innerList.add(prevValueStart);
                innerList.add(prevValueEnd);
                ansArr.add(innerList);
                prevValueStart = currValueStart;
                prevValueEnd = currValueEnd;
            }
        }
        ArrayList<Integer> innerList = new ArrayList<>();
        innerList.add(prevValueStart);
        innerList.add(prevValueEnd);
        ansArr.add(innerList);
        return ansArr;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputA = List.of(List.of(1,3), List.of(2,6), List.of(8,10), List.of(15,18));
        List<List<Integer>> expectedOutputA = List.of(List.of(1,6), List.of(8,10), List.of(15,18));
        ArrayList<ArrayList<Integer>> actualOutputA = solveScaler(inputA);
        System.out.println(expectedOutputA);
        System.out.println(actualOutputA);
        assert  expectedOutputA.equals(actualOutputA);
    }
}
