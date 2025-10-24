package Demo.ExceptionHandling.Custom_Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomException_3 extends RuntimeException {
    public CustomException_3(String message) {
        super(message);
    }
}
