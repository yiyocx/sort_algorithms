package com.yiyo.study.dynamic_programming;

public class ClimbingStairs {

    /*
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

    Note: Given n will be a positive integer.
     */

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }

    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] result = new int[n + 1];
        // We set our corner cases because we can reach the i-th step in one of two ways:
        // 1. Taking a step of 1 from (i - 1)
        // 2. Taking a step of 2 from (i - 2)
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            // The total number of ways to reach i is equal to the sum of ways of reaching (i - 1)
            // and ways of reaching (i - 2)
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
