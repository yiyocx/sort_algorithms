package com.yiyo.study.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicatedNumber {

    /*
    Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear
    time using less than O(n) space and traversing the stream sequentially O(1) times.
     */
    public static void main(String[] args) {
        FindDuplicatedNumber duplicatedNumber = new FindDuplicatedNumber();
        List<Integer> list = Arrays.asList(3, 4, 1, 4, 1);
        System.out.println(duplicatedNumber.repeatedNumber(list));
    }

    private int repeatedNumber(final List<Integer> a) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : a) {
            if (set.contains(number)) {
                return number;
            } else {
                set.add(number);
            }
        }
        return -1;
    }
}
