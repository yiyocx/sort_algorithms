package com.yiyo.study.arrays;

public class MinStepsInfiniteGrid {

    /*
    You are in an infinite 2D grid where you can move in any of the 8 directions.
    You are given a sequence of points and the order in which you need to cover the points.
    Give the minimum number of steps in which you can achieve it. You start from the first point.

    Example:
    Input : [(0, 0), (1, 1), (1, 2)]
    Output : 2
    It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
     */

    public static void main(String[] args) {
        MinStepsInfiniteGrid minSteps = new MinStepsInfiniteGrid();
        int[] A = {0, 1, 3, 3};
        int[] B = {0, 1, 2, 4};
        System.out.println(minSteps.coverPoints(A, B));
    }

    private int coverPoints(int[] A, int[] B) {
        int minSteps = 0;
        for (int i = 1; i < A.length; i++) {
            int x = Math.abs(A[i] - A[i - 1]);
            int y = Math.abs(B[i] - B[i - 1]);
            minSteps += Math.max(x, y);
        }
        return minSteps;
    }
}
