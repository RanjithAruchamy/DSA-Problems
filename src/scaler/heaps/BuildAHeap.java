package scaler.heaps;

public class BuildAHeap {

    /**
     * Given an array A of N integers, convert that array into a min heap and return the array.
     * NOTE: A min heap is a binary tree where every node has a value less than or equal to its children.
     *
     * Input:
     * A = [5, 13, -2, 11, 27, 31, 0, 19]
     *
     * One possible Heap is
     *
     *                 -2
     *                /    \
     *              5       0
     *             / \    /  \
     *           13  11  19   27
     *           /
     *         31
     *
     * It can be seen that each parent has a value smaller than its children. Hence it is a Valid Heap.
     * The Heap in the Array format is [-2, 5, 0, 13, 11, 19, 27, 31].
     *
     *  Some more possible heaps are  [-2, 0, 5, 13, 11, 27, 19, 31], [-2, 5, 0, 11, 27, 13, 19, 31], etc.
     * You can return any possible Valid Heap Structure.
     */

    public static int[] buildHeap(int[] A) {
        int n = A.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {

            int parent = i;
            while ( (2 * parent) + 1 < n) {
                int leftChild = (2 * parent) + 1, rightChild = (2 * parent) + 2;

                int min = Math.min(A[parent], A[leftChild]);
                if (rightChild < n) {
                    min = Math.min(min, A[rightChild]);
                }

                if (min == A[parent]) break;
                else if (min == A[leftChild]) {
                    swap(A, parent, leftChild);
                    parent = leftChild;
                } else {
                    swap(A, parent, rightChild);
                    parent = rightChild;
                }
            }
        }
        return A;
    }

    private static void swap(int[] A, int child, int parent) {
        int temp = A[child];
        A[child] = A[parent];
        A[parent] = temp;
    }

    public static void main(String[] args) {
        buildHeap(new int[]{5, 13, -2, 11, 27, 31, 0, 19});
    }
}
