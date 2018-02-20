package com.yiyo.study.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KMostFrequentElements {

    /*
    Given a non-empty array of integers, return the k most frequent elements.
     */
    public static void main(String[] args) {
        KMostFrequentElements kMost = new KMostFrequentElements();
        int[] A = {1, 6, 2, 1, 6, 1, 6};
        System.out.println(kMost.freqK(A, 2));
    }

    private List<Integer> freqK(int[] A, int k) {
        Map<Integer, Integer> frequences = new HashMap<>();

        // Count the frequency for each element
        for (int i = 0; i < A.length; i++) {
            if (frequences.containsKey(A[i])) {
                frequences.put(A[i], frequences.get(A[i]) + 1);
            } else {
                frequences.put(A[i], 1);
            }
        }

        // Get the max frequency
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : frequences.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        // Initialize an array of ArrayList. Index is frequency, value is list of numbers
        List<Integer>[] arr = new ArrayList[max + 1];
        for (int i = 1; i <= max; i++) {
            arr[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : frequences.entrySet()) {
            Integer number = entry.getKey();
            Integer count = entry.getValue();
            arr[count].add(number);
        }


        // Add most frequent numbers to result
        List<Integer> result = new ArrayList<>();
        for (int i = max; i >= 1; i--) {
            if (!arr[i].isEmpty()) {
                result.addAll(arr[i]);
            }

            if (result.size() == k) {
                break;
            }
        }
        return result;
    }
}
