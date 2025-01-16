package com.example.design_pattern.problem.multithread.threadinterference;

public class ThreadinterferenceDemo {

    private static int counter = 0;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter++;
            }
        });

        Thread thread2 = new Thread(() -> {

            for (int i = 0; i < 10000; i++) {
                counter++;
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
