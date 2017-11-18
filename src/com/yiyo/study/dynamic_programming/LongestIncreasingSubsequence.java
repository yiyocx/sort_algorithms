package com.yiyo.study.dynamic_programming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /*
    Given an unsorted array of integers, find the length of longest increasing subsequence

    For example, given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing subsequence
    is [2, 3, 7, 101], therefore the length is 4.

    Note that there may be more than one LIS combination,
    it is only necessary for you to return the length.
     */

    public static void main(String[] args) {
        int[] sequence = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(sequence));
    }

    private static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int totalMax = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, 1 + result[j]);
                }
            }
            result[i] = max;
            totalMax = Math.max(max, totalMax);
        }
        return totalMax;
    }
}
