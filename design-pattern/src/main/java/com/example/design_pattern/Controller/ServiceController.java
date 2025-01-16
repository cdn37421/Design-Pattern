package com.example.design_pattern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.design_pattern.Service.PrototypeService;
import com.example.design_pattern.Service.SingletonService;

@RestController
public class ServiceController {

    @Autowired
    private SingletonService singletonService;

    @Autowired
    private PrototypeService prototypeService;

    @GetMapping("/doSingleton")
    public String doSingleton() {
        singletonService.print();
        return "doSingleton";
    }

    @GetMapping("/doPrototype")
    public String doPrototype() {
        prototypeService.print(); // 每次訪問會創建新的實例
        return "doPrototype";
    }

    @GetMapping("/getSingletonInstanceCount")
    public int getSingletonInstanceCount() {
        return SingletonService.getInstanceCount();
    }

    @GetMapping("/getPrototypeInstanceCount")
    public int getPrototypeInstanceCount() {
        return PrototypeService.getInstanceCount(); // 使用靜態方法來獲取計數
    }

    @GetMapping("getCurrenthreadName")
    public String getCurrenthreadName() {
        return Thread.currentThread().getName();
    }
}