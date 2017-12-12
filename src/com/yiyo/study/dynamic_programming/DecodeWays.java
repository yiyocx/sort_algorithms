package com.yiyo.study.dynamic_programming;

public class DecodeWays {
    /*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:
    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    Example :
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    The number of ways decoding "12" is 2.
     */
    public static void main(String[] args) {
        DecodeWays dw = new DecodeWays();
        System.out.println(dw.numDecodings("121"));
        System.out.println(dw.numDecodings("1243"));
        System.out.println(dw.numDecodings("25"));
        System.out.println(dw.numDecodings("31"));

    }

    private int numDecodings(String A) {
        if (A.isEmpty()) {
            return 0;
        }

        int[] result = new int[A.length() + 1];
        result[0] = 1;
        // If A has only one element we should validate if it is zero or not
        result[1] = A.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= A.length(); i++) {
            // If the current digit is not 0, we must add it to the number of decodings
            if (A.charAt(i - 1) > '0') {
                result[i] = result[i - 1];
            }

            // If second last digit is 1 or is smaller than 2 and last digit is smaller than 7
            // the last two digits together form a valid character
            if (A.charAt(i - 2) == '1' || (A.charAt(i - 2) == '2' && A.charAt(i - 1) < '7')) {
                result[i] += result[i - 2];
            }
        }
        return result[A.length()];
    }
}
