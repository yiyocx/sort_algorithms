package com.yiyo.study.sorting;

import java.util.Arrays;

/**
 * Best Case: O(n * log(n))
 * Average Case: O(n * log(n))
 * Worst Case: O(n * log(n))
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {14, 5, 2, 15, 1, 6, 9, 8, 3, 10, 5, 11, 4, 13, 12, 7};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] L = new int[mid - low + 1];
        int[] R = new int[high - mid];

        for (int i = 0; i < L.length; i++) {
            L[i] = arr[low + i];
        }

        for (int i = 0; i < R.length; i++) {
            R[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i += 1;
            } else {
                arr[k] = R[j];
                j += 1;
            }
            k += 1;
        }

        while (i < L.length) {
            arr[k] = L[i];
            i += 1;
            k += 1;
        }

        while (j < R.length) {
            arr[k] = R[j];
            j += 1;
            k += 1;
        }
    }
}

