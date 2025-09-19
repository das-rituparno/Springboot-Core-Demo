package First_Chapter.Bean.Config;

import First_Chapter.Bean.Entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Person createPerson1() {
        return new Person("Ritu", 26);
    }
}
