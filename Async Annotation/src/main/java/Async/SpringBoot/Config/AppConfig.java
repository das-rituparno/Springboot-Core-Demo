package Async.SpringBoot.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {
    @Bean(name = "MyThreadPoolExecutor")
    public Executor taskPoolExecutor() {
        int min_pool_size = 2;
        int max_pool_size = 4;
        int queue_size = 3;

        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(min_pool_size);
        pool.setMaxPoolSize(max_pool_size);
        pool.setQueueCapacity(queue_size);
        pool.setThreadNamePrefix("My Custom Thread - ");
        pool.initialize();
        return pool;
    }
}
