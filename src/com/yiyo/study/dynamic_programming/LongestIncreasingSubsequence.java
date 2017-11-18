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
        // Corner case
        if (nums.length == 0) {
            return 0;
        }

        int[] result = new int[nums.length];
        // Every value has a LIS combination of length 1 with itself
        Arrays.fill(result, 1);
        // We need to store the maximum of all combination because the array is not sorted
        // so the last value of the array is not always the greatest
        int totalMax = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            // We have to check every value from 0 to i looking for possible combinations
            for (int j = 0; j < i; j++) {
                // If some previous value is less than the current then we add 1 to our current position
                // and store the maximum between that value and our local max
                if (nums[j] < nums[i]) {
                    max = Math.max(max, 1 + result[j]);
                }
            }
            result[i] = max;
            // Here we make sure we only keep our greatest maximum for all the array and not just for the current num
            totalMax = Math.max(max, totalMax);
        }
        return totalMax;
    }
}
