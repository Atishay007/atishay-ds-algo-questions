package com.arrays;

public class StockBuyAndSellToMaxProfit {
    public static void main(String[] args) {
        int[] nums = {8, 5, 12, 9, 19, 1};

        int bP = nums[0];
        int profit = -1;
        int negativeProfit = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {

            int tmpProfit = nums[i] - bP;

            if (tmpProfit >= 0) {
                profit = Math.max(profit, tmpProfit);
            }

            if (tmpProfit < 0) {
                negativeProfit = -Math.min(Math.abs(negativeProfit), Math.abs(tmpProfit));
            }

            if (bP > nums[i]) {
                bP = nums[i];
            }
        }

        if (profit != -1) {
            System.out.println("Profit is: " + profit);
        } else {
            System.out.println("Negative Profit is: " + negativeProfit);
        }
     }
}
