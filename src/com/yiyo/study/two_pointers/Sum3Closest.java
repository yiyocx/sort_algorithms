package com.yiyo.study.two_pointers;

import java.util.Arrays;

public class Sum3Closest {

    /*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
    Return the sum of the three integers.
    Assume that there will only be one solution

    Example:
    given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
     */
    public static void main(String[] args) {
        Sum3Closest sum3 = new Sum3Closest();

        int[] A = {1, 1, -1, -1, 3};
        System.out.println(sum3.threeSumClosest(A, -1));
        int[] B = {-1, 2, 1, -4};
        System.out.println(sum3.threeSumClosest(B, 1));
        int[] C = {-4, -1, 2, 6, 7};
        System.out.println(sum3.threeSumClosest(C, 5));
    }

    private int threeSumClosest(int[] A, int target) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE; // The smallest distance between a sum an the target
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            int k = A.length - 1;

            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                int diff = Math.abs(sum - target);

                if (diff == 0) {
                    return sum;
                }

                if (diff < min) {
                    min = diff;
                    result = sum;
                }

                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
