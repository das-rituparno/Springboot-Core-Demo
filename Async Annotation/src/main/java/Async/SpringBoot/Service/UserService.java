package Async.SpringBoot.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    @Async
    public void asyncMethodTest() {
        System.out.println("Inside Async Method " + Thread.currentThread().getName());
    }
}
