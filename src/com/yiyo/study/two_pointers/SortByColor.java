package com.yiyo.study.two_pointers;

import java.util.Arrays;

/**
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class SortByColor {
    /*
    Given an array with n objects colored red, white or blue,
    sort them so that objects of the same color are adjacent,
    with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

    Note: Using library sort function is not allowed.
     */
    public static void main(String[] args) {
        int[] nums = {2, 1, 0, 0, 1, 0, 2, 1, 1, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        SortByColor sc = new SortByColor();
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
