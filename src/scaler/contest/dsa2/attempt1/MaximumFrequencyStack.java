package scaler.contest.dsa2.attempt1;

import java.util.*;

public class MaximumFrequencyStack {

    /**
     * You are given a matrix A of size N x 2 which represents different operations.
     * Assume initially you have a stack-like data structure you have to perform operations on it.
     *
     * Operations are of two types:
     * 1 x: push an integer x onto the stack and return -1.
     * 2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest count among all the elements currently in the stack.
     *
     * If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
     * A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
     *
     * Input 1:
     * A = [
     *             [1, 5]
     *             [1, 7]
     *             [1, 5]
     *             [1, 7]
     *             [1, 4]
     *             [1, 5]
     *             [2, 0]
     *             [2, 0]
     *             [2, 0]
     *             [2, 0]  ]
     *
     * Input 2:
     *  A =  [
     *         [1, 5]
     *         [2, 0]
     *         [1, 4]   ]
     *
     * Output 1:
     *  [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
     *
     *  Output 2:
     *  [-1, 5, -1]
     */

    // Time-Complexity : O(N) , Space-Complexity: O(N)
    public int[] solveEfficient(int[][] A) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Stack<Integer>> freqStack = new HashMap<>();
        int maxFreq = 0;

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int operation = A[i][0], value = A[i][1];

            if (operation == 1) {   // Push
                int freq = pushEfficient(freqMap, freqStack, value);
                maxFreq = Math.max(maxFreq, freq);
                result[i] = -1;
            } else {    //Pop
                int[] output = popEfficient(freqMap, freqStack, maxFreq);
                if (output[0] == 1) maxFreq--;
                result[i] = output[1];
            }
        }
        return result;
    }

    private int pushEfficient(Map<Integer, Integer> freqMap, Map<Integer, Stack<Integer>> freqStack, int value) {
        int freq = freqMap.getOrDefault(value, 0) + 1;
        freqMap.put(value, freq);

        if (!freqStack.containsKey(freq)) {
            freqStack.put(freq, new Stack<>());
        }

        freqStack.get(freq).push(value);

        return freq;
    }

    private int[] popEfficient(Map<Integer, Integer> freqMap, Map<Integer, Stack<Integer>> freqStack, int maxFreq) {

        Stack<Integer> stack = freqStack.get(maxFreq);
        int value = stack.pop();
        freqMap.put(value, freqMap.get(value) - 1);

        int isStackEmpty = stack.isEmpty() ? 1 : 0;

        return new int[]{isStackEmpty, value};
    }

    // Time-Complexity : O(N^2) , Space-Complexity: O(N)
    public int[] solve(int[][] A) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();

        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int operation = A[i][0], value = A[i][1];

            if (operation == 1) {   // Push
                push(freqMap, stack, value);
                result[i] = -1;
            } else {    //Pop
                int output = pop(freqMap, stack, tempStack);
                result[i] = output;
            }
        }
        return result;
    }

    private void push(Map<Integer, Integer> freqMap, Stack<Integer> stack, int value) {
        stack.push(value);
        freqMap.put(value, freqMap.getOrDefault(value, 0) + 1);
    }

    private int pop(Map<Integer, Integer> freqMap, Stack<Integer> stack, Stack<Integer> tempStack) {
        int maxFreq = 0;
        for (Integer entry : freqMap.values()) {
            maxFreq = Math.max(entry, maxFreq);
        }

        Set<Integer> maxFreqElements = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if (Objects.equals(maxFreq, entry.getValue())) {
                maxFreqElements.add(entry.getKey());
            }
        }

        int output = 0;
        while (!stack.isEmpty()) {
            if (maxFreqElements.contains(stack.peek())) {
                freqMap.put(stack.peek(), freqMap.get(stack.peek()) - 1);
                output = stack.pop();
                break;
            } else {
                tempStack.push(stack.pop());
            }
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return output;
    }
}
