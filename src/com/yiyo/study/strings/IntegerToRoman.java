package com.yiyo.study.strings;

/**
 * Time complexity: O(n)
 */
public class IntegerToRoman {
    /*
    Given an integer, convert it to a roman numeral, and return a string corresponding to its roman numeral version.
    Input is guaranteed to be within the range from 1 to 3999.
     */
    public static void main(String[] args) {
        IntegerToRoman ito = new IntegerToRoman();
        System.out.println(ito.intToRoman(3549));
        System.out.println(ito.intToRoman(1254));
    }

    private String intToRoman(int number) {
        if (number <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder("");
        while (number != 0) {
            if (number >= 1000) {
                builder.append("M");
                number -= 1000;
            } else if (number >= 900) {
                builder.append("CM");
                number -= 900;
            } else if (number >= 500) {
                builder.append("D");
                number -= 500;
            } else if (number >= 400) {
                builder.append("CD");
                number -= 400;
            } else if (number >= 100) {
                builder.append("C");
                number -= 100;
            } else if (number >= 90) {
                builder.append("XC");
                number -= 90;
            } else if (number >= 50) {
                builder.append("L");
                number -= 50;
            } else if (number >= 40) {
                builder.append("XL");
                number -= 40;
            } else if (number >= 10) {
                builder.append("X");
                number -= 10;
            } else if (number >= 9) {
                builder.append("IX");
                number -= 9;
            } else if (number >= 5) {
                builder.append("V");
                number -= 5;
            } else if (number >= 4) {
                builder.append("IV");
                number -= 4;
            } else if (number >= 1) {
                builder.append("I");
                number -= 1;
            }
        }
        return builder.toString();
    }
}
