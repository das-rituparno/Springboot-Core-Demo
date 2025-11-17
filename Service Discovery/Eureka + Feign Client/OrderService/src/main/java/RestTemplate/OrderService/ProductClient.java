package RestTemplate.OrderService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "PRODUCTSERVICE")
public interface ProductClient {

    @GetMapping("/products/{id}")
    String getProduct(@PathVariable("id") int id);
}
