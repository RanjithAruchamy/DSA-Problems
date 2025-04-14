package data_structures.Arrays;

import java.util.Arrays;

public class MergeSortedArray {

    private static int[] mergeSortedArray(int[] arrayA, int[] arrayB) {
        int[] mergedArray = new int[(arrayA.length) + (arrayB.length)];
        int index = 0;
        int arrayAIndex = 0;
        int arrayBIndex = 0;

        while(index < mergedArray.length) {

            if (arrayBIndex <= arrayB.length - 1 && arrayAIndex <= arrayA.length - 1
                    && arrayA[arrayAIndex] < arrayB[arrayBIndex]) {
                mergedArray[index] = arrayA[arrayAIndex];
                arrayAIndex++;
            } else {
                mergedArray[index] = arrayB[arrayBIndex];
                arrayBIndex++;
            }
            index++;
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        int[] arrayA = {0, 3, 4, 30};
        int[] arrayB = {4, 6, 31};

        System.out.println(Arrays.toString(mergeSortedArray(arrayA, arrayB)));
    }
}
