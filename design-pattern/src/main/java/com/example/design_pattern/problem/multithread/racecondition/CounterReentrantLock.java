package com.example.design_pattern.problem.multithread.racecondition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterReentrantLock {
    private int count = 0;

    private final Lock lock = new ReentrantLock();

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}

// 確保執行線程安全，但是用synchornized 會引入一些執行緒切換的開銷