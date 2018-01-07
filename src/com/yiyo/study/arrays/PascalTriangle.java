package com.yiyo.study.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /*
    Given numRows, generate the first numRows of Pascal’s triangle.
    Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.

    Example:
    Given numRows = 5, return:
    [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
    ]
     */

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(6));
    }

    private List<List<Integer>> generate(int A) {
        List<List<Integer>> result = new ArrayList<>(A);
        for (int line = 1; line <= A; line++) {
            int C = 1;
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= line; i++) {
                row.add(C);
                C = C * (line - i) / i;
            }
            result.add(row);
        }
        return result;
    }
}
