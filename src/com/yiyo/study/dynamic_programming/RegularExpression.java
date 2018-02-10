package com.yiyo.study.dynamic_programming;

/**
 * Time Complexity O(m * n)
 * Space Complexity O(m * n)
 */
public class RegularExpression {

    /*
    Implement wildcard pattern matching with support for '?' and '*'.
        '?' : Matches any single character.
        '*' : Matches any sequence of characters (including the empty sequence).
    The matching should cover the entire input string (not partial).

    The function prototype should be:
        int isMatch(String text, String pattern)
     */
    public static void main(String[] args) {
        RegularExpression regexp = new RegularExpression();
        System.out.println(regexp.isMatch("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "a**************************************************************************************"));
        System.out.println(regexp.isMatch("aa", "c*a*"));
        System.out.println(regexp.isMatch("aa", "a?"));
    }

    private boolean isMatch(final String text, final String pattern) {
        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            return n == 0;
        }

        // Table for storing results of sub problems
        boolean[][] result = new boolean[n + 1][m + 1];
        // Empty pattern can match with empty string
        result[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++) {
            if (pattern.charAt(j - 1) == '*') {
                result[0][j] = result[0][j - 1];
            }
        }

        // Fill the table in bottom-up fashion
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '?' || text.charAt(i - 1) == pattern.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1];
                }
                // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
                else if (pattern.charAt(j - 1) == '*') {
                    result[i][j] = result[i][j - 1] || result[i - 1][j];
                }
                // If characters don't match
                else {
                    result[i][j] = false;
                }
            }
        }
        return result[n][m];
    }
}
