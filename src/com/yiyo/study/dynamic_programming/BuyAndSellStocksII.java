package com.yiyo.study.dynamic_programming;

public class BuyAndSellStocksII {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit.
    You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
    However, you may not engage in multiple transactions at the same time
    (ie, you must sell the stock before you buy again).

    Example :
        Input : [100, 180, 260, 310, 40, 535, 695]
        Return : 865
     */
    public static void main(String[] args) {
        BuyAndSellStocksII stocks = new BuyAndSellStocksII();
        int[] A = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(stocks.maxProfit(A));
    }

    private int maxProfit(final int[] A) {
        int profit = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                int diff = A[i + 1] - A[i];
                if (diff > 0) {
                    profit += diff;
                }
            }
        }
        return profit;
    }
}
