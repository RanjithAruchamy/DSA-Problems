package scaler.contest.dsa2.attempt1;

public class LeastCapacityToShip {

    /**
     * A conveyor belt has N packages that must be shipped from one port to another within B days.
     *
     * The ith package on the conveyor belt has a weight of A[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by A).
     * We may not load more weight than the maximum weight capacity of the ship.
     * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within B days.
     *
     * Input 1:
     * A = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * B = 5
     *
     * Input 2:
     * A = [1, 2, 3, 1, 1]
     * B = 4
     *
     * Output 1:
     * 15
     * Output 2:
     * 3
     */

    public static int solve(int[] A, int B) {
        int min = Integer.MIN_VALUE, max = 0;
        for (Integer num : A) {
            min = Math.max(min, num);
            max += num;
        }

        int low = min, high = max;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isAllPackagesShipped(A, B, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isAllPackagesShipped(int[] packages, int days, int weight) {
        int weightLeft = weight;
        for (int i = 0; i < packages.length; i++) {
            if (packages[i] > weight) return false;

            if (weightLeft < packages[i]) {
                days--;
                weightLeft = weight - packages[i];
            }
            weightLeft = weightLeft - packages[i];
        }
        return days >= 0;
    }

    public static void main(String[] args) {
        assert 15 == solve(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10} , 5);
    }
}
