package com.yiyo.study;

public class MergeSort {
    private int[] numbers;
    private int[] helper;

    private int size;

    public void sort(int[] values) {
        this.numbers = values;
        size = values.length;
        this.helper = new int[size];
        mergeSort(0, size - 1);
    }

    private void mergeSort(int low, int high) {
        // Check if low is smaller than high, if not then the is sorted
        if (low < high) {
            // get index of the middle element
            int middle = low + (high - low)/2;
            // sort the left side of the array
            mergeSort(low, middle);
            // sort the right side of the array
            mergeSort(middle + 1, high);
            // combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // Copy the smallest values from either left or right side back to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side to the array into the target
        while (i <= middle) {
            numbers[k] = helper[i];
            i++;
            k++;
        }
    }

    public int[] getArray() {
        return numbers;
    }
}
