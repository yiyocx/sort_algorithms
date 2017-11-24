package com.yiyo.study.dynamic_programming;

public class UniquePaths {

    /*
    A robot is located at the top-left corner of a m x n grid.

    The robot can only move either down or right at any point in time.
    The robot is trying to reach the bottom-right corner of the grid.
    
    How many possible unique paths are there?
     */

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            result[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }


        return result[m - 1][n - 1];
    }
}
