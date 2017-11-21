package com.yiyo.study.dynamic_programming;

public class CombinationSum {

    /*
    Given an integer array with all positive numbers and no duplicates,
    find the number of possible combinations that add up to a positive integer target.
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum(nums, target));
    }

    private static int combinationSum(int[] nums, int target) {
        if (target == 0) {
            return 0;
        }

        int[] result = new int[target + 1];
        // Corner case
        result[0] = 1;

        for (int i = 1; i < result.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // We know that the number of combinations of the target is the sum of the previous combinations.
                // Example: comb[4] = comb[4 - 1] + comb[4 - 2] + comb[4 - 3]
                if (i - nums[j] >= 0) {
                    result[i] += result[i - nums[j]];
                }
            }
        }
        return result[target];
    }
}
