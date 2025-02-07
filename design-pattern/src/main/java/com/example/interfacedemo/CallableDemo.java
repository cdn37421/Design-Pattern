package com.example.interfacedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 創建 Callable 物件
        // Callable<Integer> task = () -> {
        // System.out.println("計算任務執行中");
        // Thread.sleep(2000);// 模擬耗時計算
        // return 42;
        // };

        // Future<Integer> future = executor.submit(task);

        List<Callable<String>> callables = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            final int taskId = i;
            callables.add(() -> {
                System.out.println("任務" + taskId + "執行中");
                Thread.sleep(2000);// 模擬耗時計算
                return "任務" + taskId + "執行結果";
            });
        }
        try {
            List<Future<String>> results = executor.invokeAll(callables);

            for (Future<String> future : results) {
                try {
                    System.out.println(future.get());
                } catch (ExecutionException e) {
                    System.err.println("task failed: " + e.getMessage());
                }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}

/*
 * try {
 * executor.invokeAll(callables);
 * } catch (InterruptedException e) {
 * // TODO Auto-generated catch block
 * e.printStackTrace();
 * }
 * 
 * executor.invokeAll (callables)會執行所有任務，並返回List<Future>
 * 每個Future都會對應一個任務的執行結果，
 * 如果不處理這些Future:
 * 1.將無法獲得每個任務的執行結果
 * 2.檢查任務是否有例外發生
 * 
 * 如果不關心結果及任務的執行狀態，這樣是可以的，但若是需要對結果進行處理，就會丟失關鍵資料
 * 
 */
