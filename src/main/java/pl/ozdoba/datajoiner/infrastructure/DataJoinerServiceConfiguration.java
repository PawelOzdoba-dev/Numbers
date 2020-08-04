package pl.ozdoba.datajoiner.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DataJoinerServiceConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
