package RestTemplate.OrderService.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
//        return new RestTemplate();

        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();

        // Setting the timeouts
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(50000);

        return new RestTemplate();
    }
}
