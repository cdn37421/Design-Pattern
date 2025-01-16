package com.example.design_pattern.Service;

import org.springframework.stereotype.Component;

@Component
public class SingletonService {

    private static int instanceCount = 0;

    // 私有建構子
    private SingletonService() {
        instanceCount++;
        System.out.println("SingletonService instanceCount: " + instanceCount);
    }

    public void print() {
        System.out.println("SingletonService print");
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}
