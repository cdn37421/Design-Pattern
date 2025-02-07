package com.example.leetcode;

// medium
public class Best_Time_to_Buy_II_122 {

    public static void main(String[] args) {
        maxProfit(new int[] { 7, 1, 5, 3, 6, 4 });

    }

    // 只計算上漲部分
    // 低於成本價都不管
    public static int maxProfit(int[] prices) {

        int cost = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // 最小化成本
            if (cost > prices[i]) {
                cost = prices[i];
            }
            if (prices[i] > cost) {
                // 獲利
                profit += prices[i] - cost;
                cost = prices[i];
            }
        }

        return profit;
    }
}

/*
 * 
 * Example 1:
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit =
 * 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 =
 * 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 * 
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
 * 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 * 
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the
 * stock to achieve the maximum profit of 0.
 */

// [1, 7, 5, 3, 6,7, 4, 8]

// 7
// 6 + 3
// 6 +

// 6 + 1 +4