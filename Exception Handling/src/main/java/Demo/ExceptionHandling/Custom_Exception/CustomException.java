package Demo.ExceptionHandling.Custom_Exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    HttpStatus status;

    public CustomException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
