package com.yiyo.study.sorting;

import java.util.Arrays;

/**
 * Average Case: O(n^2)
 * Worst Case: O(n^2)
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] numbers = {7, 4, 5, 2};
        System.out.println(Arrays.toString(bubbleSort.sort(numbers)));
    }

    private int[] sort(int[] numbers) {
        bubbleSort(numbers);
        return numbers;
    }

    private void bubbleSort(int[] numbers) {
        int n = numbers.length;
        int temp;
        for (int k = 0; k < n - 1; k++) {
            // (n-k-1) is for ignoring comparisons of elements which have already been compared in earlier iterations
            for (int i = 0; i < n - k - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                }
            }
        }
    }
}
