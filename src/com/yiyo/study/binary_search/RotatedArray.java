package com.yiyo.study.binary_search;

public class RotatedArray {

    /*
    Suppose a sorted array A is rotated at some pivot unknown to you beforehand.
    For example: 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2

    Find the minimum element.
    The array will not contain duplicates.
     */

    public static void main(String[] args) {
        RotatedArray rotatedArray = new RotatedArray();
        int[] arr = {4, 5, 6, 7, 8, 1, 2};
        System.out.println(rotatedArray.findMin(arr, arr.length));
    }

    private int findMin(int[] A, int n) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[start] <= A[end]) {
                return A[start];
            }
            int prev = (mid - 1) % n;
            int next = (mid + 1) % n;
            if (A[mid] < A[prev] && A[mid] < A[next]) {
                return A[mid];
            }

            if (A[mid] <= A[end]) {
                end = mid - 1;
            }

            if (A[mid] >= A[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
