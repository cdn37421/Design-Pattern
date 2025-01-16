package com.example.design_pattern.problem.multithread.racecondition;

public class Counter {

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void increment() {
        count++;
    }

}
