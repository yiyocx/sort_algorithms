package com.yiyo.study.dynamic_programming;

public class BuySellStocksWithKTransactions {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete at most k transactions.
     */
    public static void main(String[] args) {
        BuySellStocksWithKTransactions stocks = new BuySellStocksWithKTransactions();
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(stocks.maxProfit(prices, 2));
    }

    private int maxProfit(int[] A, int k) {
        if (A.length == 0 || A == null) {
            return 0;
        }

        int[][] result = new int[k + 1][A.length];

        for (int i = 1; i < result.length; i++) {
            int maxDiff = -A[0];
            for (int j = 1; j < result[0].length; j++) {
                result[i][j] = Math.max(result[i][j - 1], A[j] + maxDiff);
                maxDiff = Math.max(maxDiff, result[i - 1][j] - A[j]);
            }
        }
        return result[k][A.length - 1];
    }
}
