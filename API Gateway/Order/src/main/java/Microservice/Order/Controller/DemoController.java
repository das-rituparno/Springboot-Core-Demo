package Microservice.Order.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class DemoController {
    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(@PathVariable int id) {
        return ResponseEntity.ok("Fetched the order with id : " + id);
    }
}