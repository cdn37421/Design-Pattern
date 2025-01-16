package com.example.design_pattern.problem.multithread.threadinterference;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadinterferenceFixed2 {

    private static int counter = 0;

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                lock.lock();

                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }

        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                lock.lock();

                try {
                    counter++;
                } finally {
                    lock.unlock();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Count: " + counter);
    }

}
