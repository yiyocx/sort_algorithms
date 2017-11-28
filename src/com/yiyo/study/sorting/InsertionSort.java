package com.yiyo.study.sorting;

import java.util.Arrays;

/**
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 * <p>
 * This is faster than QuickSort only sorting very small arrays.
 * In fact, this could be used in QuickSort with arrays smaller than a certain threshold.
 *
 * @author Yiyo
 */
public class InsertionSort {

    private int[] numbers;

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] sortedArray = insertionSort.sort(new int[]{7, 13, 15, 4, 1, 8, 5, 2, 9, 3, 11, 6, 10, 14, 12});
        System.out.println(Arrays.toString(sortedArray));
    }

    private int[] sort(int[] numbers) {
        this.numbers = numbers;
        insertionSort(numbers);
        return numbers;
    }

    private void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int hole = i;

            while (hole > 0 && numbers[hole] < numbers[hole - 1]) {
                swap(hole, hole - 1);
                hole -= 1;
            }
        }
    }

    private void swap(int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}
