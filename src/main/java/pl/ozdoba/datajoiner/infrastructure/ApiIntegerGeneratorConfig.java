package pl.ozdoba.datajoiner.infrastructure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
class ApiIntegerGeneratorConfig {

    @Value("${wsclient.generate-number.url}")
    private String url;
}
