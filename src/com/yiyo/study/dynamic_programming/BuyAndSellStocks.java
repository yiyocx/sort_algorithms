package com.yiyo.study.dynamic_programming;

public class BuyAndSellStocks {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.

    If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
    design an algorithm to find the maximum profit.
     */

    public static void main(String[] args) {
        int[] A = {5, 2, 3, 7, 4, 6};
        BuyAndSellStocks buyAndSellStocks = new BuyAndSellStocks();
        System.out.println(buyAndSellStocks.maxProfit(A));
    }

    private int maxProfit(final int[] A) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < minPrice) {
                minPrice = A[i];
            } else if (A[i] - minPrice > maxProfit) {
                maxProfit = A[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
