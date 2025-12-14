package scaler.contest.dsa2.attempt3;

public class GameOfBoxes {

    /**
     * There are N piles of boxes lying on the floor. You have to play a game with these piles by performing the following operations once:
     *
     * You start from the 3rd pile, and go all the way upto Nth pile.
     * At the ith pile you pick X number of boxes and shift them to (i-1)th pile, and pick 2X number of boxes and shift them to (i-2)th pile. Given that 0<=3.X<=Ai. Where Ai is the number of boxes in the ith pile.
     * You have to maximize the number of boxes in the smallest pile that you can achieve after this operation.
     *
     * Input 1:
     * A = [1, 2, 10, 100]
     * Input 2:
     *  A = [1, 2, 3, 4, 5, 6]
     *
     *  Output 1:
     *  7
     * Output 2:
     *  3
     */

    public static int solve(int[] A) {
        int max = 0;
        for (Integer num : A) {
            max = Math.max(max, num);
        }

        int low = 0, high = max;
        long ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (checkFeasible(A, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    private static boolean checkFeasible(int[] A, int boxesToKeep) {
        int n = A.length;
        long[] temp = new long[n];

        for (int i = 0; i < n; i++) {
            temp[i] = A[i];
        }
        for (int i = n - 1; i >= 2; i--) {
            if (temp[i] < boxesToKeep) return false;

            long boxesToPick = temp[i] - boxesToKeep;
            long x = Math.min(boxesToPick / 3, A[i] / 3);

            temp[i - 1] += x;
            temp[i - 2] += 2 * x;
        }
        return temp[0] >= boxesToKeep && temp[1] >= boxesToKeep;
    }

    public static void main(String[] args) {
        assert 7 == solve(new int[]{1, 2, 10, 100});
//        assert 3 == solve(new int[]{1, 2, 3, 4, 5, 6});
    }
}
