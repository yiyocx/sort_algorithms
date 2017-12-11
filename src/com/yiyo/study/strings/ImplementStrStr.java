package com.yiyo.study.strings;

public class ImplementStrStr {

    /*
    Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
     */
    public static void main(String[] args) {
        ImplementStrStr st = new ImplementStrStr();
        System.out.println(st.strStr("hello", "ll"));
    }

    private int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();

        // The condition in the loop validates that the needle can't be longer than haystack
        for (int i = 0; i <= m - n; i++) {
            int j = 0;
            while (j < n) {
                // If any element of the needle is different in the substring from our current haystack index
                // then we break the loop and try with another one
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            // Check if we reach the end of the needle and every element is in the haystack
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
