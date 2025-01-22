package com.example.interfacedemo;

public class RunnableDemo {

    public static void main(String[] args) {

        Runnable task = new Runnable() {

            @Override
            public void run() {
                System.out.println("任務執行");
            }

        };

        Runnable task2 = () -> System.out.println("任務執行2");

        Thread thread = new Thread(task);
        thread.start();

        Thread thread2 = new Thread(task2);
        thread2.start();
    }

}

/*
 * 
 * Runnable Callable
 * 無返回值 有返回值
 * 不能拋出例外 能拋出例外
 * 方法名稱Run() 方法名稱Call()
 */

/*
 * run()
 * 是否啟動新執行緒:否
 * 執行邏輯的執行緒:在呼叫run()的當前執行緒中執行
 * 常見用途: 測試任務邏輯(不涉及多執行緒)
 */

/*
 * start()
 * 是否啟動新執行緒 : 是
 * 執行邏輯的執行緒:在新的執行緒中執行
 * 常見用途: 啟動多執行緒程式
 */
