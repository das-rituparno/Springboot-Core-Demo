package RestTemplate.OrderService.Controller;

import RestTemplate.OrderService.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    ProductClient productClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id) {

        String responseFromProductAPI = productClient.getProduct(id);
        System.out.println("Response from Product API call is - " + responseFromProductAPI);

        return ResponseEntity.ok("order call is successful");
    }
}
