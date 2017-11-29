package com.yiyo.study.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Average Case: O(n * log(n))
 * Worst Case: O(n^2)
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {7, 9, 3, 6, 1, 10, 4, 13, 15, 2, 14, 8, 11, 5, 12};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int arr[], int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);

            // Recursively sort elements before partition and after partition
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    private int partition(int arr[], int left, int right) {
        int pivot = arr[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, partitionIndex);
                partitionIndex++;
            }
        }

        // swap partition index with the pivot
        swap(arr, partitionIndex, right);
        return partitionIndex;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    /*
    Randomize the pivot index helps to increase the probability of obtaining O(n * log(n)) in the Worst case
     */
    private void quickSortRandom(int[] arr, int left, int right) {
        if (left != right) {
            int i = left;
            int j = right;

            Random random = new Random();
            int pivotIndex = random.nextInt(right - left) + left;
            int pivot = arr[pivotIndex];

            while (i < j) {
                while (arr[i] < pivot) {
                    i += 1;
                }

                while (arr[j] > pivot) {
                    j -= 1;
                }

                if (i <= j) {
                    swap(arr, i, j);
                    i += 1;
                    j -= 1;
                }
            }

            if (left < j) {
                quickSortRandom(arr, left, j);
            }

            if (right > i) {
                quickSortRandom(arr, i, right);
            }
        }
    }
}

