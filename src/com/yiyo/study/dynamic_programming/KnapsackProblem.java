package com.yiyo.study.dynamic_programming;

public class KnapsackProblem {

    public static void main(String[] args) {
        int values[] = {1, 4, 5, 7};
        int wt[] = {1, 3, 4, 5};
        int W = 7;

        System.out.println(knapsack(values, wt, W));
    }

    private static int knapsack(int values[], int wt[], int W) {
        int n = values.length;
        int result[][] = new int[n + 1][W + 1];

        // Initialize the first row (item 0) with zeros because there is no item there
        for (int col = 0; col <= W; col++) {
            result[0][col] = 0;
        }

        // Initialize all the first column (weight 0) with zeros because we can't store anything there
        for (int row = 0; row <= n; row++) {
            result[row][0] = 0;
        }

        // Fill the values row by row
        for (int item = 1; item <= n; item++) {
            for (int weight = 1; weight <= W; weight++) {
                // Is the accumulated items weight less than or equal to the current weight
                if (wt[item - 1] <= weight) {
                    // Calculate the remaining weight we have to add an item
                    int remainingW = weight - wt[item - 1];
                    // Check if the value of the accumulated item + the value of the item that fits the remaining weight
                    // is greater than the value without the current item itself
                    result[item][weight] = Math.max(values[item - 1] + result[item - 1][remainingW], result[item - 1][weight]);
                } else {
                    // If the accumulated items weight is more than the current weight,
                    // we just leave the previous weight because we can't add the current item
                    result[item][weight] = result[item - 1][weight];
                }
            }
        }

        // Print the matrix just to see the process
        for (int[] rows : result) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }

        return result[n][W];
    }
}
