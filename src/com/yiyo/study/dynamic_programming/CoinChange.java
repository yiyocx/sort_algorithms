package com.yiyo.study.dynamic_programming;

import java.util.Arrays;

public class CoinChange {

    /*
    You are given coins of different denominations and a total amount of money amount.
    Write a function to compute the fewest number of coins that you need to make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return -1.
     */

    public static void main(String[] args) {
        int[] coins = {2, 5, 1};
        int amount = 7;
        System.out.println(coinChange(coins, amount));
    }

    private static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] result = new int[amount + 1];
        Arrays.fill(result, amount + 1);
        result[0] = 0;

        for (int coin : coins) {
            for (int j = 1; j <= amount; j++) {
                if (coin <= j) {
                    result[j] = Math.min(result[j], 1 + result[j - coin]);
                }
            }
        }
        return result[amount] > amount ? -1 : result[amount];
    }
}
