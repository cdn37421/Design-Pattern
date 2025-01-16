package com.example.design_pattern.Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype") // 設定作用域為多例模式
public class PrototypeService {

    private static int instanceCount = 0; // 靜態計數器，所有實例共用

    public PrototypeService() {
        instanceCount++; // 每次初始化時增加計數
        System.out.println("PrototypeService 被初始化，這是第 " + instanceCount + " 次初始化");
    }

    public void print() {
        System.out.println("執行 PrototypeService 的操作...");
    }

    public static int getInstanceCount() {
        return instanceCount;
    }
}