package scaler.binarysearch;

public class AllocateBooks {

    /**
     * Given an array of integers A of size N and an integer B.
     * The College library has N books. The ith book has A[i] number of pages.
     * You have to allocate books to B number of students so that the maximum number of pages allocated to a student is minimum.
     *
     * A book will be allocated to exactly one student.
     * Each student has to be allocated at least one book.
     * Allotment should be in contiguous order, for example: A student cannot be allocated book 1 and book 3, skipping book 2.
     * Calculate and return that minimum possible number.
     *
     * NOTE: Return -1 if a valid assignment is not possible
     *
     * Input 1:
     * A = [12, 34, 67, 90]
     * B = 2
     *
     * Input 2:
     * A = [12, 15, 78]
     * B = 4
     *
     * Output 1:
     * 113
     *
     * Output 2:
     * -1
     */

    public static int books(int[] A, int B) {
        if (A.length < B) return -1;
        long[] maxAndSum = findMaxAndSum(A);
        int low = (int) maxAndSum[0], high = (int) maxAndSum[1];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAllBooksAllocated(mid, A, B)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isAllBooksAllocated(int pages, int[] books, int numberOfStudents) {
        int pagesLeft = pages;
        int studentsAllocated = 1;
        for (Integer num : books) {
            if (pagesLeft >= num) {
                pagesLeft = pagesLeft - num;
            } else {
                studentsAllocated++;
                pagesLeft = pages - num;
            }
        }
        if (studentsAllocated > numberOfStudents) return false;
        return true;
    }

    private static long[] findMaxAndSum(int[] A) {
        long max = Integer.MIN_VALUE, sum = 0L;
        for (Integer num : A) {
            if (num > max) max = num;
            sum += num;
        }
        return new long[] {max, sum};
    }

    public static void main(String[] args) {
        int[] input = {12, 34, 67, 90};
        int[] input1 = {12, 15, 78};
        assert -1 == books(input1, 4);
    }
}
