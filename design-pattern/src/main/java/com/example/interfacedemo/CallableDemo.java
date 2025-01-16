package com.example.interfacedemo;

import java.util.concurrent.Callable;

public class CallableDemo {
    public static void main(String[] args) {

        Callable<Integer> task = () -> {
            System.out.println();

            return 0;
        };

    }
}
