package com.example.design_pattern.problem.multithread.racecondition;

public class CounterSync {

    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }

}

// 確保執行線程安全，但是用synchornized 會引入一些執行緒切換的開銷