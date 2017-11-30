package com.yiyo.study.search;

/**
 * Time Complexity: O(log(n))
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int positionIterative = binarySearch.search(new int[]{1, 2, 6, 8, 9, 10, 12, 14, 15}, 8);
        System.out.println("Iterative implementation=" + positionIterative);

        int[] array = new int[]{1, 2, 6, 8, 9, 10, 12, 14, 15};
        int positionRecursive = binarySearch.search(array, 0, array.length, 12);
        System.out.println("Recursive implementation=" + positionRecursive);
    }

    public int search(int[] array, int value) {
        int low = 0;
        int high = array.length;

        while (low <= high) {
            // This way to get the mid index prevents an overflow in higher integers
            int mid = low + ((high - low) / 2);
            if (array[mid] == value) {
                return mid;
            } else if (value < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int search(int[] array, int low, int high, int value) {
        if (low > high) {
            return -1;
        }

        int mid = low + ((high - low) / 2);
        if (array[mid] == value) {
            return mid;
        } else if (value < array[mid]) {
            return search(array, low, mid - 1, value);
        } else {
            return search(array, mid + 1, high, value);
        }
    }
}

