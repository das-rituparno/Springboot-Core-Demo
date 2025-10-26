package Demo.FiltersChapter.Config;

import Demo.FiltersChapter.Filter.MyFilter1;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public FilterRegistrationBean<MyFilter1> myFirstFilter() {
        FilterRegistrationBean<MyFilter1> filterOne = new FilterRegistrationBean<>();
        filterOne.setFilter(new MyFilter1());
        filterOne.addUrlPatterns("/*");
        filterOne.setOrder(1);
        return filterOne;
    }
}
