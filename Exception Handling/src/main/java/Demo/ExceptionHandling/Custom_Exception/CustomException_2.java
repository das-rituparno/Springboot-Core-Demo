package Demo.ExceptionHandling.Custom_Exception;

import org.springframework.http.HttpStatus;

public class CustomException_2 extends Exception {
    private final HttpStatus status;
    public CustomException_2(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
