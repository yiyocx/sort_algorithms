package com.yiyo.study.strings;

/**
 * Time complexity: O(n)
 */
public class ReverseWords {

    /*
    Given an input string, reverse the string word by word.

    Example:
    Given s = "the sky is blue", return "blue is sky the".
     */
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        System.out.println(rw.reverseWords("   the sky is blue"));
    }

    private String reverseWords(String a) {
        StringBuilder result = new StringBuilder("");
        String[] words = a.split("\\s");

        for (int j = words.length - 1; j >= 0; j--) {
            result.append(words[j]);
            result.append(" ");
        }
        return result.toString().trim();
    }

    //
    private String reverseWords2(String a) {
        char[] array = a.toCharArray();
        int n = a.length();

        for (int i = 0; i < n; i++) {
            while (i < n && array[i] == ' ') {
                i++;
            }
            int start = i;

            while (i < n && array[i] != ' ') {
                i++;
            }
            int end = i - 1;

            if (end < start) {
                break;
            }
            reverse(array, start, end);
        }
        reverse(array, 0, array.length - 1);
        return new String(array).trim();
    }

    private void reverse(char[] array, int start, int end) {
        char temp;
        for (int i = 0; i < (end - start + 1) / 2; i++) {
            temp = array[start + i];
            array[start + i] = array[end - i];
            array[end - i] = temp;
        }
    }
}
