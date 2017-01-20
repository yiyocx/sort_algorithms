package com.yiyo.study.sorting;

import java.util.Arrays;

public class MergeSort {

    private int[] numbers;
    private int[] helper;

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] sortedArray = mergeSort.sort(new int[]{14, 5, 2, 15, 1, 6, 9, 8, 3, 10, 5, 11, 4, 13, 12, 7});
        System.out.println(Arrays.toString(sortedArray));
    }

    public int[] sort(int[] numbers) {
        this.numbers = numbers;
        helper = new int[numbers.length];
        mergeSort(0, numbers.length - 1);
        return numbers;
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private void merge(int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i += 1;
            } else {
                numbers[k] = helper[j];
                j += 1;
            }
            k += 1;
        }

        while (i <= mid) {
            numbers[k] = helper[i];
            i += 1;
            k += 1;
        }

        while (j <= high) {
            numbers[k] = helper[j];
            j += 1;
            k += 1;
        }
    }
}

