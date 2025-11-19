package leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {

    public static int findFinalValueHashSet(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            set.add(num);
        }

        while (set.contains(original)) {
            original = original * 2;
        }

        return original;
    }

    public static int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (Integer num : nums) {
            if (original == num) {
                original = original * 2;
            }
        }
        return original;
    }

    public static void main(String[] args) {
        int[] input = {5,3,6,1,12};
        int[] input1 = {2,7,9};
        int[] input2 = {4,2,8,9};

        System.out.println(findFinalValueHashSet(input2, 2));
    }
}
