package com.yiyo.study.dynamic_programming;

public class JumpGame {

    /*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.

    For example:
    A = [2,3,1,1,4], return true
    A = [3,2,1,0,4], return false
     */

    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int currentIndex = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= currentIndex) {
                currentIndex = i;
            }
        }
        return currentIndex == 0;
    }
}
