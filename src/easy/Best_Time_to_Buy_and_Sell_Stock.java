package easy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class Best_Time_to_Buy_and_Sell_Stock {
    class Solution {
        public int maxProfit(int[] prices) {
            int profit = 0;
            int buy = Integer.MAX_VALUE;
            int n = prices.length;

            for(int i = 0; i < n; i++) {
                buy = Math.min(buy, prices[i]);
                profit = Math.max(profit, prices[i] - buy);
            }

            return profit;
        }
    }
}
