package com.yiyo.study.two_pointers;

import java.util.*;

public class Sum3Zero {

    /*
    Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
    Find all unique triplets in the array which gives the sum of zero.

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    and must not contain duplicate triplets.
     */
    public static void main(String[] args) {
        Sum3Zero sum3 = new Sum3Zero();
        List<Integer> A = Arrays.asList(-1, 0, 1, 2, -1, -4);
        List<List<Integer>> result = sum3.threeSum(A);
        for (List<Integer> integers : result) {
            System.out.println(integers);
        }
    }

    private List<List<Integer>> threeSum(List<Integer> A) {
        Collections.sort(A);
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < A.size(); i++) {
            int j = i + 1;
            int k = A.size() - 1;

            while (j < k) {
                int sum = A.get(i) + A.get(j) + A.get(k);

                if (sum == 0) {
                    set.add(Arrays.asList(A.get(i), A.get(j), A.get(k)));
                }

                if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
