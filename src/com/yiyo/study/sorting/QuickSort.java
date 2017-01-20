package com.yiyo.study.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Yiyo on 1/18/17.
 */
public class QuickSort {

    private int[] numbers;

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] sortedArray = quickSort.sort(new int[]{7, 9, 3, 6, 1, 10, 4, 13, 15, 2, 14, 8, 11, 5, 12});
        System.out.println(Arrays.toString(sortedArray));
    }

    public int[] sort(int[] numbers) {
        this.numbers = numbers;
        quicksort(0, numbers.length - 1);
        return numbers;
    }

    private void quicksort(int left, int right) {
        if (left != right) {
            int i = left;
            int j = right;

            Random random = new Random();
            int pivotIndex = random.nextInt(right - left) + left;
            int pivot = numbers[pivotIndex];

            while (i < j) {
                while (numbers[i] < pivot) {
                    i += 1;
                }

                while (numbers[j] > pivot) {
                    j -= 1;
                }

                if (i <= j) {
                    swap(i, j);
                    i += 1;
                    j -= 1;
                }
            }

            if (left < j) {
                quicksort(left, j);
            }

            if (right > i) {
                quicksort(i, right);
            }
        }
    }

    private void swap(int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }
}

