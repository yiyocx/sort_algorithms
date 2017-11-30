package com.yiyo.study.arrays;

public class MaxSumContiguousSubArray {

    /*
     * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
     *
     * For example:
     * Given the array [-2,1,-3,4,-1,2,1,-5,4],
     * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
     */

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, -3, 4, -1, 2, 1, -5, 4};
        MaxSumContiguousSubArray max = new MaxSumContiguousSubArray();
        System.out.println(max.maxSubArrayRecursive(arr, arr.length));
    }

    // O(n)
    private int maxSubArray(final int[] A) {
        int sum = Integer.MIN_VALUE;
        int temp = 0;

        for (int i = 0; i < A.length; i++) {
            if (temp < 0) {
                temp = A[i];
            } else {
                temp += A[i];
            }

            sum = Math.max(sum, temp);
        }
        return sum;
    }

    // O(n * log(n))
    private int maxSubArrayRecursive(int[] A, int n) {
        if (n == 1) {
            return A[0];
        }

        int mid = n / 2;
        int maxLeft = maxSubArrayRecursive(A, mid);
        int maxRight = maxSubArrayRecursive(A, n - mid);

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid - 1; i >= 0; i--) {
            sum += A[i];
            leftSum = Math.max(sum, leftSum);
        }

        sum = 0;
        for (int i = mid; i < n; i++) {
            sum += A[i];
            rightSum = Math.max(sum, rightSum);
        }

        int answer = Math.max(maxLeft, maxRight);
        answer = Math.max(answer, leftSum + rightSum);
        return answer;
    }
}
