package com.example.algo.Greedy;

public class ActivitySelection {
    public static void main(String[] args) {
        int[][] activities = {
                { 1, 4 }, // A
                { 2, 6 }, // B
                { 5, 7 }, // C
                { 3, 8 }, // D
                { 5, 9 }, // E
                { 8, 10 } // F
        };

        int maxActivities = selectActivities(activities);
        System.out.println("最多可以選擇的活動數量是: " + maxActivities);
    }

    public static int selectActivities(int[][] activities) {

        return 0;
    }
}
// 問題描述
// 假設有一組活動，每個活動都有一個開始時間和結束時間。目標是選擇最多的活動，使得選擇的活動之間不重疊。

// 解法
// 貪心算法的策略是每次選擇結束時間最早的活動，這樣就能為接下來的活動留出最多的空間。