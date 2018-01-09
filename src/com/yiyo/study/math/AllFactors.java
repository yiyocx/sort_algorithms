package com.yiyo.study.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(sqrt(n))
 */
public class AllFactors {

    /*
    Given a number N, find all factors of N.
    Example:
    N = 6, factors = {1, 2, 3, 6}
    Make sure the returned array is sorted.
     */
    public static void main(String[] args) {
        AllFactors af = new AllFactors();
        System.out.println(af.allFactors(36));
    }

    private List<Integer> allFactors(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> higherTerms = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                // This is to avoid duplicate the value when i and n / i are the same
                if (n / i == i) {
                    result.add(i);
                } else {
                    result.add(i);
                    higherTerms.add(n / i);
                }
            }
        }

        for (int i = higherTerms.size() - 1; i >= 0; i--) {
            result.add(higherTerms.get(i));
        }
        return result;
    }
}
