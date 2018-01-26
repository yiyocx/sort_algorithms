package com.yiyo.study.two_pointers;

public class ContainerWithMostWater {

    /*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
    'n' vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).

    Find two lines, which together with x-axis forms a container, such that the container contains the most water.
    Your program should return an integer which corresponds to the maximum area of water that can be contained
    ( Yes, we know maximum area instead of maximum volume sounds weird.
    But this is 2D plane we are working with for simplicity ).
     */
    public static void main(String[] args) {
        ContainerWithMostWater container = new ContainerWithMostWater();
        int[] A = {1, 5, 4, 3};
        System.out.println(container.maxArea(A));
    }

    private int maxArea(int[] A) {
        int maxArea = 0;
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            int base = j - i;
            int height = Math.min(A[i], A[j]);
            maxArea = Math.max(maxArea, base * height);

            if (A[i] > A[j]) {
                j--;
            } else {
                i++;
            }
        }
        return maxArea;
    }
}
