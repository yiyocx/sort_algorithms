package com.yiyo.study.arrays;

import java.util.Arrays;

public class SpiralOrderMatrix {

    /*
    Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.

    Given the following matrix:
    [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
    ]
    you should return:
    [1, 2, 3, 6, 9, 8, 7, 4, 5]
     */

    public static void main(String[] args) {
        int[][] A = {
                {133, 241, 22, 258, 187, 150, 79, 207, 196, 401, 366, 335, 198},
                {401, 55, 260, 363, 14, 318, 178, 296, 333, 296, 45, 37, 10},
                {112, 374, 79, 12, 97, 39, 310, 223, 139, 91, 171, 95, 126}
        };
        System.out.println(Arrays.toString(spiralOrder(A)));
    }

    private static int[] spiralOrder(final int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[] spiral = new int[rows * cols];
        int top = 0;
        int left = 0;
        int right = cols - 1;
        int bottom = rows - 1;
        int direction = 0;
        int count = 0;

        while (left <= right && top <= bottom) {
            // left to right
            if (direction == 0) {
                for (int i = left; i <= right; i++) {
                    spiral[count] = A[top][i];
                    count++;
                }
                top++;
                direction = 1;
            }
            // top to bottom
            else if (direction == 1) {
                for (int i = top; i <= bottom; i++) {
                    spiral[count] = A[i][right];
                    count++;
                }
                right--;
                direction = 2;
            }
            // right to left
            else if (direction == 2) {
                for (int i = right; i >= left; i--) {
                    spiral[count] = A[bottom][i];
                    count++;
                }
                bottom--;
                direction = 3;
            }
            // bottom to top
            else {
                for (int i = bottom; i >= top; i--) {
                    spiral[count] = A[i][left];
                    count++;
                }
                left++;
                direction = 0;
            }
        }

        return spiral;
    }
}
