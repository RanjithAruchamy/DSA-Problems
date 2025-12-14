package scaler.contest.dsa2.attempt3;

public class MaximumBuildings {

    /**
     * There are N buildings in a city that lie in a straight line one behind the other.
     * Sam is a photographer and wants to take pictures of the buildings. He can stand at top of any building and take a photo. Apparently, he can only take one photo as he is running low on memory.
     * The photo contains all the buildings in front of the one he's currently on that don't get hidden by the previous building and have height higher than the building on which Sam is standing. Sam is currently at position 0.
     * All the buildings take positions from 1 to N. Sam wants his photo to contain the maximum number of buildings.
     * The heights of the buildings are given in an array A. Help Sam by telling him to stand on the closest building that can help achieve his goal. If there are multiple such buildings, choose the one with the lowest index.
     *
     *  Suppose the array A given is [4, 2, 1 3].
     *The number of buildings that Sam can capture from first building is 0, from second building he can click 1 building, from third also he can capture 1 building and 0 from the fourth building. So the answer will be 2nd index.
     *
     *
     * Input 1:
     * [153, 199, 301, 245]
     * Input 2:
     * [304, 456, 409, 52, 201, 278]
     *
     * Output 1:
     * 1
     * Output 2:
     * 4
     */

    public static int solveOptimize(int[] A) {
        int n = A.length;

        int[] suffMax = new int[n];
        suffMax[n - 1] = 0;
        int max = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
                suffMax[i] = 0;
            } else {
                suffMax[i] = suffMax[i + 1] + 1;
            }
        }

        int maxBuilding = 0, position = 0;
        for (int i = 0; i < n; i++) {
            if (suffMax[i] > maxBuilding) {
                maxBuilding = suffMax[i];
                position = i + 1;
            }
        }

        return position;
    }

    public static int solve(int[] A) {
        int max = 0;
        int position = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] > A[j - 1] && A[j] > A[i]) {
                    count++;
                } else {
                    count = 0;
                }
                if (count > max) {
                    position = i + 1;
                    max = count;
                }
            }
        }
        return position;
    }

    public static void main(String[] args) {
        assert 1 == solveOptimize(new int[]{153, 199, 301, 245});
        assert 4 == solveOptimize(new int[]{304, 456, 409, 52, 201, 278});
    }

}
