package com.yiyo.study.math;

import java.util.Arrays;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RearrangeArrayNumberEncoding {

    /*
    Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
    Example:
    Input : [1, 0]
    Return : [0, 1]
     */
    public static void main(String[] args) {
        RearrangeArrayNumberEncoding rearrangeArray = new RearrangeArrayNumberEncoding();
        int[] A = {3, 2, 0, 1};
        int[] B = {2, 4, 3, 1, 0, 5};
        rearrangeArray.arrange(A);
        rearrangeArray.arrange(B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
    }

    private void arrange(int[] A) {
        int n = A.length;

        // We need to encode two numbers in one place using the formula: (A[A[i]] % n) * n.
        // The way to get the old value is A[A[i]] % n
        for (int i = 0; i < n; i++) {
            int oldValue = A[A[i]] % n;
            int transformation = A[i] + (oldValue * n);
            A[i] = transformation;
        }

        // The way to get the new value is A[i] / n
        for (int i = 0; i < n; i++) {
            int newValue = A[i] / n;
            A[i] = newValue;
        }
    }
}
