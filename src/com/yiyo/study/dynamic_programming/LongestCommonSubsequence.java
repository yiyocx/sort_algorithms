package com.yiyo.study.dynamic_programming;

public class LongestCommonSubsequence {

    /*
    Given two sequences, find the length of longest subsequence present in both of them.
    A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     */

    public static void main(String[] args) {
        char A[] = "AGGTAB".toCharArray();
        char B[] = "GXTXAYB".toCharArray();
        System.out.println(lengthOfLCS(A, B));
    }

    private static int lengthOfLCS(char[] A, char[] B) {
        // Corner case
        if (A.length == 0 || B.length == 0) {
            return 0;
        }

        int[][] result = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                // If last characters of both sequences match we add 1 to our previous subsequences accumulated value
                if (A[i - 1] == B[j - 1]) {
                    result[i][j] = 1 + result[i - 1][j - 1];
                } else {
                    // If last characters of both sequences don't match we take the maximum value between
                    // one subsequence without the last character and the other subsequence
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }

        return result[A.length][B.length];
    }
}
