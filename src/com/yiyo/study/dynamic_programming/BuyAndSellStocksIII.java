package com.yiyo.study.dynamic_programming;

public class BuyAndSellStocksIII {

    /*
    Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete at most two transactions.

    Note:
    You may not engage in multiple transactions at the same time
    (ie, you must sell the stock before you buy again).

    Example :
        Input : [1 2 1 2]
        Output : 2

    Explanation :
        Day 1 : Buy
        Day 2 : Sell
        Day 3 : Buy
        Day 4 : Sell
     */
    public static void main(String[] args) {
        BuyAndSellStocksIII stocks = new BuyAndSellStocksIII();
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(stocks.maxProfit(prices));
    }

    private int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;

        // Assume we only have 0 money at first
        for (int price : prices) {
            // The maximum if we've just sold 2nd stock so far.
            release2 = Math.max(release2, hold2 + price);
            // The maximum if we've just buy  2nd stock so far.
            hold2 = Math.max(hold2, release1 - price);
            // The maximum if we've just sold 1nd stock so far.
            release1 = Math.max(release1, hold1 + price);
            // The maximum if we've just buy  1st stock so far.
            hold1 = Math.max(hold1, -price);
        }
        // Since release1 is initiated as 0, so release2 will always higher than release1.
        return release2;
    }
}
