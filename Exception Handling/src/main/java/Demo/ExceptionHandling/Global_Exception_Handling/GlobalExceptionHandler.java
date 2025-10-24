package Demo.ExceptionHandling.Global_Exception_Handling;

import Demo.ExceptionHandling.Custom_Exception.CustomException_2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException_2.class)
    public ResponseEntity<String> handleCustomException2(CustomException_2 ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }
}
