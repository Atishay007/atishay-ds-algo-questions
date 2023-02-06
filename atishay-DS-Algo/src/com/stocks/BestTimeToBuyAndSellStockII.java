package com.stocks;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * https://www.geeksforgeeks.org/stock-buy-sell/
 * Multiple sell allowed, every time prices[i] will become new buyPrice
 * after calculating profit and here we have to maximize profit so
 * We will add new profit in main profit when new profit >0
 * TC:O(n)
 * SC:O(1)
 * We can do Single transaction.
 */
public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(getMaxProfit(prices));
        prices = new int[]{1, 2, 3, 4, 5};
        System.out.println(getMaxProfit(prices));
        prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(getMaxProfit(prices));
        prices = new int[]{100, 180, 260, 310, 40, 535, 695};
        System.out.println(getMaxProfit(prices));
    }

    private static int getMaxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            //Profit formula: SP-BP
            int tmpProfit = prices[i] - buyPrice;

            //The SP will become buyPrice for future transactions, as we can do multiple transactions
            buyPrice = prices[i];
            /*
            We will include profit when it is positive,
            we don't want to show losses in Balance sheet.
            */
            if (tmpProfit >= 0) {
                maxProfit = maxProfit + tmpProfit;
            }
        }
        return maxProfit;
    }
}