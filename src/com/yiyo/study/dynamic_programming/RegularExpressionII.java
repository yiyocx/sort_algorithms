package com.yiyo.study.dynamic_programming;

public class RegularExpressionII {

    /*
    Implement regular expression matching with support for '.' and '*'.
        '.' Matches any single character.
        '*' Matches zero or more of the preceding element.

    The matching should cover the entire input string (not partial).

    The function prototype should be:
        int isMatch(const char *s, const char *p)
    Some examples:
        isMatch("aa","a") → 0
        isMatch("aa","aa") → 1
        isMatch("aaa","aa") → 0
        isMatch("aa", "a*") → 1
        isMatch("ab", ".*") → 1
        isMatch("aab", "c*a*b") → 1
     */
    public static void main(String[] args) {
        RegularExpressionII regexp = new RegularExpressionII();
        System.out.println(regexp.isMatch("b", "b*"));
        System.out.println(regexp.isMatch("aab", "c*a*b"));
        System.out.println(regexp.isMatch("xyz", "a*.b"));
        System.out.println(regexp.isMatch("xfasgasg", ".*"));
    }

    private boolean isMatch(String text, String pattern) {
        // Table for storing results of sub problems
        boolean result[][] = new boolean[text.length() + 1][pattern.length() + 1];
        // Empty pattern can match with empty string
        result[0][0] = true;

        // Handle cases like a* or a*b or a*b*c and so on
        for (int j = 1; j < result[0].length; j++) {
            if (pattern.charAt(j - 1) == '*') {
                result[0][j] = result[0][j - 2];
            }
        }

        for (int i = 1; i < result.length; i++) {
            for (int j = 1; j < result[0].length; j++) {
                // Current characters are considered as matching in two cases
                // (a) characters actually match
                // (b) current character of pattern is '.'
                if (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
                    result[i][j] = result[i - 1][j - 1];
                }
                // Two cases if we see a '*'
                // a) previous character of '*' is '.'
                // b) current character matches with previous character of '*'
                // In both cases we have to choose between ignore '*' with its previous character
                // and the calculated match for the previous character of text
                else if (pattern.charAt(j - 1) == '*') {
                    result[i][j] = result[i][j - 2];
                    if (pattern.charAt(j - 2) == '.' || text.charAt(i - 1) == pattern.charAt(j - 2)) {
                        result[i][j] = result[i][j] | result[i - 1][j];
                    }
                }
                // If characters don't match
                else {
                    result[i][j] = false;
                }
            }
        }
        return result[text.length()][pattern.length()];
    }
}
