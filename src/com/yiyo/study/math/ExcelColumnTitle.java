package com.yiyo.study.math;

public class ExcelColumnTitle {

    /*
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.
    Example:
        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
     */
    public static void main(String[] args) {
        ExcelColumnTitle title = new ExcelColumnTitle();
        System.out.println(title.convertToTitle(17733));
        System.out.println(title.convertToTitle(943566));
    }

    private String convertToTitle(int A) {
        StringBuilder title = new StringBuilder("");
        while (A > 0) {
            int rem = A % 26;
            if (rem == 0) {
                title.append('Z');
                A = (A / 26) - 1;
            } else {
                title.append((char) ('A' - 1 + rem));
                A = A / 26;
            }
        }
        return title.reverse().toString();
    }
}
