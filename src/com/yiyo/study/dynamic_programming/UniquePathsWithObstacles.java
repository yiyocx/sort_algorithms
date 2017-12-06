package com.yiyo.study.dynamic_programming;

import java.util.Arrays;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        UniquePathsWithObstacles pathsWithObstacles = new UniquePathsWithObstacles();

        int[][] A = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(A));
        System.out.println(pathsWithObstacles.uniquePathsWithObstacles(A));

        int[][] B = {{0, 0, 1, 0, 1, 1, 1, 1}, {0, 1, 0, 1, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0, 1}};
        System.out.println(Arrays.deepToString(B));
        System.out.println(pathsWithObstacles.uniquePathsWithObstacles(B));
    }

    private int uniquePathsWithObstacles(int[][] A) {
        int m = A.length;
        int n = A[0].length;

        if (m == 1 && n == 1) {
            return A[m - 1][n - 1] == 0 ? 1 : 0;
        }

        int[][] result = new int[m][n];

        // Set the first position.
        // If no obstacle there we set 1 because we can start moving from that position.
        // If first position is an obstacle we cannot move from there so we left it as zero.
        if (A[0][0] == 0) {
            result[0][0] = 1;
        }

        // Initialize first column of the matrix
        for (int i = 1; i < m; i++) {
            if (A[i][0] == 0) {
                result[i][0] = result[i - 1][0];
            }
        }

        // Initialize first row of the matrix
        for (int j = 1; j < n; j++) {
            if (A[0][j] == 0) {
                result[0][j] = result[0][j - 1];
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // If current cell is not obstacle
                if (A[i][j] == 0) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
