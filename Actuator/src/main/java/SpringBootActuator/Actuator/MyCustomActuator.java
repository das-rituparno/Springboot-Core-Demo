package SpringBootActuator.Actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class MyCustomActuator {
    @ReadOperation
    public String healthCheck() {
        return "Hello World";
    }
    @ReadOperation
    public String read(@Selector String name, @Selector String message) {
        return "Hello: " + name + " Message for you is : " + message;
    }
}
