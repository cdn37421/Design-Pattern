package com.example.design_pattern.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.design_pattern.Service.SingletonService;

// Spring 預設使用 Singleton 來管理 Bean，所以只要在類別上使用 @Component 或其他注解（例如 @Service、@Repository 等），Spring 就會確保這個類別是以單例模式管理的。
@RestController
public class SingletonController {

    @Autowired
    private SingletonService singletonService;

    @GetMapping("/doSomething")
    public String getMethodName() {
        singletonService.print();

        return "doSomething";
    }

    @GetMapping("/getInstanceCount")
    public int getInstanceCount() {
        return SingletonService.getInstanceCount();
    }

}
