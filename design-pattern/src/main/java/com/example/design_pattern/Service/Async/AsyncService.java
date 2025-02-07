package com.example.design_pattern.Service.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void performAsyncTask() throws InterruptedException {

        Thread.sleep(5000);

        System.out.println("async task over");
    }
}
