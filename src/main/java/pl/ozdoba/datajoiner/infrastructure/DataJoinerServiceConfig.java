package pl.ozdoba.datajoiner.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.ozdoba.datajoiner.domain.AddIntegersOperator;
import pl.ozdoba.datajoiner.domain.DataJoinerService;

@Configuration
class DataJoinerServiceConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    DataJoinerService<Integer> dataJoinerService(ApiIntegerGeneratorConfig config, RestTemplate restTemplate){
        return new DataJoinerService<>(
                new ApiIntegerGeneratorRepository(restTemplate, config),
                new RandomIntegerGeneratorRepository(),
                new AddIntegersOperator()
        );
    }
}
