package com.yiyo.study.binary_search;

/**
 * Time Complexity: O(log(n))
 */
public class SquareRootInteger {

    /*
    Implement int sqrt(int x).
    Compute and return the square root of x.
    If x is not a perfect square, return floor(sqrt(x))

    Example :
    Input : 11
    Output : 3
     */
    public static void main(String[] args) {
        SquareRootInteger square = new SquareRootInteger();
        System.out.println(square.sqrt(4));
        System.out.println(square.sqrt(11));
        System.out.println(square.sqrt(2147483647));
    }

    private int sqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid * mid == x) {
                return mid;
            }

            if (mid < x / mid) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
