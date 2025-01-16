package com.example.design_pattern.problem.multithread.visibility;

public class VisibiltyDemo {

    private static volatile boolean flag = false; // 不使用 volatile

    public static void main(String[] args) {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            flag = true; // 改變共享變數的值
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) { // 讀取共享變數的值
                // 繼續等待，直到 flag 為 true
            }
            System.out.println("Flag is true!"); // 如果永遠無法看到 flag 改變，這裡就不會被執行
        });

        writerThread.start();

        readerThread.start();
    }
}
