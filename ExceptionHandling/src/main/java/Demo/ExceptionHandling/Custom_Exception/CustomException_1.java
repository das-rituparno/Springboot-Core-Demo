package Demo.ExceptionHandling.Custom_Exception;

import org.springframework.http.HttpStatus;

public class CustomException_1 extends Exception {
    private HttpStatus status;
    private String message;

    public CustomException_1(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
