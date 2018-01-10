package com.yiyo.study.math;

public class IntegerToBinary {

    /*
    Given a number N >= 0, find its representation in binary.
     */
    public static void main(String[] args) {
        IntegerToBinary it = new IntegerToBinary();
        System.out.println(it.findDigitsInBinary(6));
        System.out.println(it.findDigitsInBinary(2));
    }

    private String findDigitsInBinary(int A) {
        StringBuilder builder = new StringBuilder();
        if (A <= 0) {
            builder.append(0);
        }

        while (A > 0) {
            builder.append(A % 2);
            A = A / 2;
        }
        return builder.reverse().toString();
    }
}
