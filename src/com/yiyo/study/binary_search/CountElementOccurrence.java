package com.yiyo.study.binary_search;

/**
 * Time Complexity: O(log(n))
 */
public class CountElementOccurrence {

    /*
    Given a sorted array of integers, find the number of occurrences of a given target value.
    Your algorithm’s runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return 0

    Example :
        Given [5, 7, 7, 8, 8, 10] and target value 8, return 2.
     */
    public static void main(String[] args) {
        CountElementOccurrence count = new CountElementOccurrence();
        int[] A = {5, 7, 7, 8, 8, 10};
        System.out.println(count.findCount(A, 8));
    }

    private int findCount(final int[] A, int B) {
        int result = 0;
        int first = binarySearch(A, B, true);
        int last = binarySearch(A, B, false);

        if (first != -1 && last != -1) {
            result = (last - first) + 1;
        }
        return result;
    }

    private int binarySearch(int[] A, int B, boolean first) {
        int result = -1;
        int start = 0;
        int end = A.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (A[mid] == B) {
                result = mid;
                if (first) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (B < A[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}
