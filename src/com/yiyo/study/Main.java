package com.yiyo.study;

import com.yiyo.study.sorting.MergeSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(new int[] {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48});
    }
}
