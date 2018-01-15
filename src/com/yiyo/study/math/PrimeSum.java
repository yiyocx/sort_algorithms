package com.yiyo.study.math;

import java.util.ArrayList;
import java.util.List;

public class PrimeSum {

    /*
    Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
    If there are more than one solutions possible, return the lexicographically smaller solution.
     */
    public static void main(String[] args) {
        PrimeSum prime = new PrimeSum();
        System.out.println(prime.primeSum(20));
        System.out.println(prime.primeSum(4));
        System.out.println(prime.primeSum(10));
    }

    private List<Integer> primeSum(int A) {
        List<Integer> result = new ArrayList<>(2);
        IsPrime p = new IsPrime();
        for (int i = 2; i <= A / 2; i++) {
            int rem = A - i;
            if (p.isPrime(i) && p.isPrime(rem)) {
                result.add(i);
                result.add(rem);
                break;
            }
        }
        return result;
    }
}
