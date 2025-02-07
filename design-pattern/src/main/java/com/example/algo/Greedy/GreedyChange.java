package com.example.algo.Greedy;

public class GreedyChange {
    public static void main(String[] args) {
        int[] coins = { 25, 10, 5, 1 }; // 硬幣面額
        int amount = 63; // 目標金額
        int coinCount = getMinCoins(coins, amount);
        System.out.println("最少需要的硬幣數量是: " + coinCount);
    }

    public static int getMinCoins(int[] coins, int amount) {
        int count = 0;

        for (int coin : coins) {
            while (amount >= coin) {
                amount -= coin;
                count++;
            }

        }
        return count;
    }
}

/*
 * 
 * 問題描述
 * 有面額為 1, 5, 10, 25 的硬幣，目標是找出用最少數量的硬幣來達到目標金額（例如： 63 元）。
 * 
 * 解法
 * 貪心算法的核心是每次都選擇當前最有利的選擇。對於找零問題，我們可以每次選擇面額最大的硬幣來儘可能減少剩餘的金額。
 */