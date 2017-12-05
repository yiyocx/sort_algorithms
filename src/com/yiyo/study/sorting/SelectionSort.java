package com.yiyo.study.sorting;

import java.util.Arrays;

/**
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 1, 3, 7, 5};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n - 1; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
