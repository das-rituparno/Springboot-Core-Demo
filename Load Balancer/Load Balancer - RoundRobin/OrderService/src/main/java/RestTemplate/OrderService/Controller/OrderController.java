package RestTemplate.OrderService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    RestTemplate restTemplate;

    @Value("${product.service.baseurl}")
    String productBaseURL;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable int id) {

        String response = restTemplate.getForObject(productBaseURL + "/products/" + id, String.class);

        System.out.println("Response from Product API called from Order Service : " + response);
        return ResponseEntity.ok("order call is successful");
    }
}
