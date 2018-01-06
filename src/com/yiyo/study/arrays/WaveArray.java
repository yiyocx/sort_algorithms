package com.yiyo.study.arrays;

import java.util.Arrays;

public class WaveArray {

    /*
    Given an array of integers, sort the array into a wave like array and return it,
    In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

    Example:
    Given [1, 2, 3, 4]
    One possible answer : [2, 1, 4, 3]
    Another possible answer : [4, 1, 3, 2]
     */

    public static void main(String[] args) {
        WaveArray waveArray = new WaveArray();
        int[] A = {10, 5, 6, 3, 2, 20, 100, 80};
        System.out.println(Arrays.toString(waveArray.waveLexicographicallySmallest(A)));
    }

    // Time Complexity: O(n)
    private int[] wave(int[] A) {
        for (int i = 0; i < A.length; i += 2) {
            if (i > 0 && A[i - 1] > A[i]) {
                swap(A, i, i - 1);
            }

            if (i < A.length - 1 && A[i + 1] > A[i]) {
                swap(A, i, i + 1);
            }
        }
        return A;
    }

    // If there are multiple answers possible, return the one thats lexicographically smallest.
    // Time Complexity: O(n * log(n)) because Arrays.sort() uses QuickSort
    private int[] waveLexicographicallySmallest(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i += 2) {
            swap(A, i, i + 1);
        }
        return A;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
