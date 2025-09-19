package Second_Chapter.Dependency_Injection.Config;

import Second_Chapter.Dependency_Injection.Entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    @Bean(name = "one")
    public Person createPerson1() {
        return new Person("Ritu", 26);
    }

    @Bean(name = "two")
    public Person createPerson2() {
        return new Person("Dwitiya", 20);
    }

    @Bean(name = "default")
    @Primary
    public Person createPerson3() {
        return new Person("Default", 00);
    }
}
