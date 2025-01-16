package com.example.design_pattern.problem.multithread.ThreadPool;

public class ThreadPoolDemo {

    public static void main(String[] args) {

    }

}

class Task implements Runnable {

    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {

        System.out.println("Task " + taskId + "is being executed by" + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

    }

}