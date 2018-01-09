package com.yiyo.study.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time Complexity: O(n * log(n))
 */
public class SieveEratosthenes {

    /*
    Given a number N, find all prime numbers upto N ( N included ).
    Example:
    if N = 7, all primes till 7 = {2, 3, 5, 7}

    Make sure the returned array is sorted.
     */
    public static void main(String[] args) {
        SieveEratosthenes sieve = new SieveEratosthenes();
        System.out.println(sieve.sieve(7));
    }

    private List<Integer> sieve(int A) {
        boolean[] primes = new boolean[A + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        double limit = Math.sqrt(A);
        for (int i = 2; i <= limit; i++) {
            if (primes[i]) {
                for (int j = 2; i * j <= A; j++) {
                    primes[i * j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>(A);
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }
}
