package com.yiyo.study.dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    /*
    Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s
    can be segmented into a space-separated sequence of one or more dictionary words.
    You may assume the dictionary does not contain duplicate words.

    For example, given
    s = "iamyiyo",
    dict = ["i", "yiyo", "am"].

    Return true because "iamyiyo" can be segmented as "i am yiyo"
     */

    public static void main(String[] args) {
        String s = "iamyiyo";
        List<String> dict = Arrays.asList("i", "yiyo", "am");
        System.out.println(wordBreak(s, dict));
    }

    private static boolean wordBreak(String s, List<String> wordDict) {
        // Corner case
        if (s.isEmpty()) {
            return false;
        }

        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }
}
