package com.stocks;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * TC:O(n)
 * SC:O(1)
 * We can do Single transaction.
 */
public class BestTimeToBuyAndSellStockI {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(getMaxProfit(prices));
        /*
        Edge case: If length is then we should get 0 i profit as
         no transaction happened.
         */

        prices = new int[]{1};
        System.out.println(getMaxProfit(prices));
    }

    private static int getMaxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
            profit = Math.max(profit, prices[i] - buyPrice);
        }
        return profit;
    }
}
