package com.example.design_pattern.problem.multithread.racecondition;

import org.springframework.stereotype.Service;

//@Service
public class RaceConditionDemo {

    public static void main(String[] args) {
        CounterAtmoic counter = new CounterAtmoic();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        // 等待兩個線程執行結束

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
    }
}

// 會發現結果不一定是2000
// 因為counter 並不是原子操作，執行時可能發生競態條件(RaceCondition)

// 步驟1: 將內存從 count 讀取到 cpu暫存器
// 步驟2: 將讀取值加1
// 步驟3: 將修改的值寫回內存