package hw_10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Programmer junior() {
        return new Junior();
    }

    @Bean
    public Programmer middle() {
        return new Middle();
    }

    @Bean
    public Programmer senior() {
        return new Senior();
    }
}
