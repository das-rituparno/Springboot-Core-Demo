package Demo.ExceptionHandling.Controller;

import Demo.ExceptionHandling.Custom_Exception.*;
import Demo.ExceptionHandling.Response_Status.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class DemoController {
    @GetMapping("/error-response")
    public ResponseEntity<?> getUser() {
        try {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Request not correct, and userID is not found");
        }
        catch (CustomException e) {
            ErrorResponse response = new ErrorResponse(new Date(), e.getMessage(), e.getStatus().value());
            return new ResponseEntity<>(response, e.getStatus());
        }
        catch (Exception e) {
            ErrorResponse response = new ErrorResponse(new Date(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/controller-level")
    public ResponseEntity<?> getUser2() throws CustomException_1 {
        throw new CustomException_1(HttpStatus.BAD_REQUEST, "controller level exception handling testing");
    }

    @ExceptionHandler(CustomException_1.class)
    public ResponseEntity<?> handleCustomException(CustomException_1 ex) {
        return new ResponseEntity<>(ex.getMessage(), ex.getStatus());
    }

    @GetMapping("/global-level")
    public ResponseEntity<?> getUser3() throws CustomException_2 {
        throw new CustomException_2(HttpStatus.BAD_REQUEST, "global level exception handling testing");
    }

    @GetMapping("/response-status")
    public ResponseEntity<?> getUser4() throws CustomException_3 {
        throw new CustomException_3("response status exception testing");
    }
}
