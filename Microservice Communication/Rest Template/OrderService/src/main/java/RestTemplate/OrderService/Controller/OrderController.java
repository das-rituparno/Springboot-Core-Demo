package RestTemplate.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id) {

        // Invoke product API
        String response = restTemplate
                .getForObject("http://localhost:8082/products/" + id, String.class);
        System.out.println("Response from Product API called from Order Service : " + response);

        return ResponseEntity.ok("order call is successful");
    }
}
