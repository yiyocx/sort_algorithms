package com.yiyo.study.math;

public class ExcelColumnNumber {

    /*
    Given a column title as appears in an Excel sheet, return its corresponding column number.
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
        ExcelColumnNumber excelColumnNumber = new ExcelColumnNumber();
        String A = "ZFA";
        System.out.println(excelColumnNumber.titleToNumber(A));
    }

    private int titleToNumber(String A) {
        int number = 0;
        for (int i = 0; i < A.length(); i++) {
            // This is just like base 26 number conversion
            number *= 26;
            number += A.charAt(i) - 'A' + 1;
        }
        return number;
    }
}
