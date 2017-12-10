package com.yiyo.study.strings;

/**
 * Time complexity: O(n)
 */
public class RomanToInteger {

    /*
    Given a roman numeral, convert it to an integer.

    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static void main(String[] args) {
        RomanToInteger rto = new RomanToInteger();
        int testCase = rto.romanToInt("MMMCCLXXXVII");
        assert 3287 == testCase;
        System.out.println(testCase);
    }

    private int romanToInt(String A) {
        int result = 0;

        for (int i = 0; i < A.length(); i++) {
            int current = getValue(A.charAt(i));

            // We have to check the current value with the next value
            if (i + 1 < A.length()) {
                int next = getValue(A.charAt(i + 1));
                if (current >= next) {
                    result += current;
                } else {
                    // In this case, value of the current symbol is less than the next symbol
                    // so we can avoid to check the next symbol incrementing the index
                    result += next - current;
                    i++;
                }
            } else {
                result += current;
            }
        }
        return result;
    }

    private int getValue(char num) {
        switch (num) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 1;
        }
    }
}
