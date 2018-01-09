package com.yiyo.study.math;

/**
 * Time Complexity: O(sqrt(n))
 * Space Complexity: O(1)
 */
public class IsPrime {

    /*
    Given a number N, verify if N is prime or not.
    Return 1 if N is prime, else return 0.
     */
    public static void main(String[] args) {
        IsPrime ip = new IsPrime();
        System.out.println(ip.isPrime(7));
        System.out.println(ip.isPrime(24));
        System.out.println(ip.isPrime(3));
    }

    private boolean isPrime(int A) {
        // Corner case
        if (A < 2) {
            return false;
        }

        // Square root because n = a * b so, b = n / a.
        double limit = Math.sqrt(A);
        for (int i = 2; i <= limit; i++) {
            if (A % i == 0) {
                return false;
            }
        }
        return true;
    }
}
