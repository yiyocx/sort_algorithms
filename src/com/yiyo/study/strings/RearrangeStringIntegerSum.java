package com.yiyo.study.strings;

public class RearrangeStringIntegerSum {

    /*
    Given a string containing uppercase alphabets and integer digits (from 0 to 9),
    the task is to print the alphabets in the order followed by the sum of digits.

    Examples:
        Input : AC2BEW3
        Output : ABCEW5

        Input: ACCBA10D2EW30
        Output: AABCCDEW6
     */
    public static void main(String[] args) {
        RearrangeStringIntegerSum string = new RearrangeStringIntegerSum();
        System.out.println(string.arrangeString("AC2BEW3"));
        System.out.println(string.arrangeString("ACCBA10D2EW30"));
    }

    private String arrangeString(String str) {
        StringBuilder result = new StringBuilder();

        int ALPHABET_SIZE = 26;
        char[] charCount = new char[ALPHABET_SIZE];
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (Character.isUpperCase(currentChar)) {
                charCount[currentChar - 'A'] += 1;
            } else {
                sum += (currentChar - '0');
            }
        }

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            char ch = (char) (i + 'A');

            while (charCount[i] > 0) {
                result.append(ch);
                charCount[i]--;
            }
        }
        if (sum > 0) {
            result.append(sum);
        }
        return result.toString();
    }
}
