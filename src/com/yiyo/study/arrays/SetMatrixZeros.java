package com.yiyo.study.arrays;

import java.util.Arrays;

/**
 * Time Complexity: O(m * n)
 * Space Complexity: O(1)
 */
public class SetMatrixZeros {

    /*
    Given an m x n matrix of 0s and 1s, if an element is 0, set its entire row and column to 0.
    Do it in place.

    Example:
    Given array A as
    1 0 1
    1 1 1
    1 1 1
    On returning, the array A should be :
    0 0 0
    1 0 1
    1 0 1
     */
    public static void main(String[] args) {
        SetMatrixZeros matrix = new SetMatrixZeros();
        int[][] A = {{1, 0, 0, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}};
        matrix.setZeroes(A);

        for (int[] value : A) {
            System.out.println(Arrays.toString(value));
        }
    }

    private void setZeroes(int[][] A) {
        boolean fillRow = false;
        boolean fillCol = false;
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && A[i][j] == 0) {
                    fillCol = true;
                }

                if (j == 0 && A[i][j] == 0) {
                    fillRow = true;
                }

                if (A[i][j] == 0) {
                    A[0][j] = 0;
                    A[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[0][j] == 0 || A[i][0] == 0) {
                    A[i][j] = 0;
                }
            }
        }

        if (fillRow) {
            for (int i = 0; i < m; i++) {
                A[i][0] = 0;
            }
        }

        if (fillCol) {
            for (int j = 0; j < n; j++) {
                A[0][j] = 0;
            }
        }
    }
}
