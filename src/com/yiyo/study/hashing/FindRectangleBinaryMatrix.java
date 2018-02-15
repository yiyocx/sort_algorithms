package com.yiyo.study.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindRectangleBinaryMatrix {

    /*
    There is a given binary matrix, we need to find if there exists any rectangle or square
    in the given matrix whose all four corners are equal to 1.

    Examples:
        Input :
            mat[][] = { 1 0 0 1 0
                    0 0 1 0 1
                    0 0 0 1 0
                    1 0 1 0 1}
        Output : Yes
        as there exists-
        1 0 1
        0 1 0
        1 0 1
     */
    public static void main(String[] args) {
        FindRectangleBinaryMatrix matrix = new FindRectangleBinaryMatrix();
        int[][] A = {{0, 0, 1, 0}, {1, 0, 1, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
        int[][] B = {{1, 0, 0, 1, 0}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 0}, {1, 0, 1, 0, 1}};
        int[][] C = {{0, 0}, {0, 0}, {0, 0}};
        System.out.println(matrix.hasRectangle(A));
        System.out.println(matrix.hasRectangle(B));
        System.out.println(matrix.hasRectangle(C));
    }

    private boolean hasRectangle(int[][] A) {
        Map<Integer, Set<Integer>> table = new HashMap<>();
        int rows = A.length;
        int cols = A[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                for (int k = j + 1; k < cols; k++) {
                    if (A[i][j] == 1 && A[i][k] == 1) {
                        Set<Integer> jValues = table.get(j);
                        Set<Integer> kValues = table.get(k);
                        if (jValues != null && jValues.contains(k) &&
                                kValues != null && kValues.contains(j)) {
                            return true;
                        }

                        if (jValues == null) {
                            jValues = new HashSet<>();
                        }

                        if (kValues == null) {
                            kValues = new HashSet<>();
                        }

                        jValues.add(k);
                        kValues.add(j);
                        table.put(j, jValues);
                        table.put(k, kValues);
                    }
                }
            }
        }
        return false;
    }
}
