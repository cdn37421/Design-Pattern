package com.example.leetcode;

// easy
public class Best_Time_to_Buy_121 {

    public static void main(String[] args) {
        maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });
        // 0 7 3 14 2 5 15
    }

    // 最小減最大
    public static int maxProfit(int[] prices) {

        int min = prices[0];
        int maxProfit = 0;

        // 不用從0開始，因為D1已經被假設成最低
        for (int i = 1; i < prices.length; i++) {

            min = Math.min(min, prices[i]);

            maxProfit = Math.max(maxProfit, prices[i] - min);

        }

        return maxProfit;
    }
}
// You are given an array prices where prices[i] is the price of a given stock
// on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you
// cannot achieve any profit, return 0.