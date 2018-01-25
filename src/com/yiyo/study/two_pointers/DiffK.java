package com.yiyo.study.two_pointers;

public class DiffK {

    /*
    Given an array ‘A’ of sorted integers and another non negative integer k,
    find if there exists 2 indices i and j such that A[i] - A[j] = k, i != j.

     Example: Input :
        A : [1 3 5]
        k : 4
     Output : YES as 5 - 1 = 4
     */
    public static void main(String[] args) {
        DiffK diffK = new DiffK();
        int[] A = {1, 2, 2, 3, 4};
        System.out.println(diffK.diffPossible(A, 0));
    }

    private boolean diffPossible(int[] A, int B) {
        int n = A.length;

        int i = 0;
        int j = 1;
        while (i < n && j < n) {
            int diff = A[j] - A[i];
            
            if (diff == B && i != j) {
                return true;
            } else if (diff < B) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}
