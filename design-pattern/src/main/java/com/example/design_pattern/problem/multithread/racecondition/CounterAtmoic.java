package com.example.design_pattern.problem.multithread.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtmoic {

    private final AtomicInteger count = new AtomicInteger();

    public int getCount() {
        return count.get();
    }

    public void increment() {
        count.incrementAndGet();
    }

}

// AtomicInteger 是基於 CAS(Compare-And-Swap)實現的，效率較高，適合用於簡單的技術需求