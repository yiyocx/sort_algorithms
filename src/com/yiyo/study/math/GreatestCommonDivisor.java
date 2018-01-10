package com.yiyo.study.math;

/**
 * Time Complexity: O(log(min(a, b)))
 */
public class GreatestCommonDivisor {

    /*
    Given 2 non negative integers m and n, find gcd(m, n)
     */
    public static void main(String[] args) {
        GreatestCommonDivisor gcd = new GreatestCommonDivisor();
        System.out.println(gcd.gcd(8, 12));
        System.out.println(gcd.gcd(7, 32));
        System.out.println(gcd.gcd(4, 2));
        System.out.println(gcd.gcd(3, 9));
    }

    private int gcd(int A, int B) {
        if (A == 0) {
            return B;
        }
        return gcd(B % A, A);
    }
}
