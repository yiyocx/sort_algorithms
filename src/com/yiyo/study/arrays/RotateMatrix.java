package com.yiyo.study.arrays;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2) in both cases
 */
public class RotateMatrix {

    /*
    You are given an n x n 2D matrix representing an image.
    Rotate the image by 90 degrees (clockwise).
    You need to do this in place.
     */
    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix.rotateAntiClockwise(A);

        for (int[] row : A) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Clockwise direction
    private void rotate(int[][] A) {
        transpose(A);
        reverseRows(A);
    }

    private void transpose(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A[0].length; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
    }

    private void reverseRows(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A.length - 1; j < k; j++, k--) {
                int temp = A[i][j];
                A[i][j] = A[i][k];
                A[i][k] = temp;
            }
        }
    }

    // Anti-Clockwise direction
    private void rotateAntiClockwise(int[][] A) {
        int n = A.length;
        for (int row = 0; row < n / 2; row++) {
            for (int col = row; col < n - 1 - row; col++) {
                int temp = A[row][col];
                // Right to Top
                A[row][col] = A[col][n - 1 - row];
                // Bottom to Right
                A[col][n - 1 - row] = A[n - 1 - row][n - 1 - col];
                // Left to Bottom
                A[n - 1 - row][n - 1 - col] = A[n - 1 - col][row];
                // Top to Left
                A[n - 1 - col][row] = temp;
            }
        }
    }
}
