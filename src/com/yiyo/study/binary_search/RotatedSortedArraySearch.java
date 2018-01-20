package com.yiyo.study.binary_search;

/**
 * Time Complexity: O(log(n))
 */
public class RotatedSortedArraySearch {

    /*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.
    (i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).
    You are given a target value to search. If found in the array, return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
     */
    public static void main(String[] args) {
        RotatedSortedArraySearch iu = new RotatedSortedArraySearch();
        int[] A = {3, 4, 5, 1, 2};
        System.out.println(iu.search(A, 2));
    }

    private int search(int[] A, int key) {
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid] == key) {
                return mid;
            }

            if (A[start] < A[mid]) {
                if (key >= A[start] && key < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (key > A[mid] && key <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
