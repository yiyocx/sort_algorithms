package com.yiyo.study.dynamic_programming;

public class HouseRobber {

    /*
    You are a professional robber planning to rob houses along a street.
    Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
    that adjacent houses have security system connected and it will automatically contact the police if two adjacent
    houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount
    of money you can rob tonight without alerting the police.
     */

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 9, 7};
        System.out.println(houseRobber(nums));
    }

    // Solution with Time: O(n) and Space: O(n)
    private static int houseRobber(int[] nums) {
        // Base cases
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] results = new int[nums.length];
        // position 0 is always the first option but position 1 is the highest value between the first two houses
        results[0] = nums[0];
        results[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            // We have two choices:
            // (i - 2) represents when the thief rob the house and
            // (i - 1) represents when the thief decided not to rob the house
            results[i] = Math.max(nums[i] + results[i - 2], results[i - 1]);
        }

        return results[nums.length - 1];
    }

    // Solution with Time: O(n) and Space: O(1)
    private static int houseRobber2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int maxValue = 0;

        for (int i = 2; i < nums.length; i++) {
            maxValue = Math.max(nums[i] + a, b);
            a = b;
            b = maxValue;
        }

        return maxValue;
    }
}
