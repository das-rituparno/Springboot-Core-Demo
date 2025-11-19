package com.conceptandcoding.AsyncAnnotation.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ServiceClass {
    @Async
    public void asyncMethod() {
        System.out.println("inside async method " + Thread.currentThread().getName());
    }
}
