package pl.ozdoba.datajoiner.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.ozdoba.datajoiner.domain.DataRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ApiIntegerGeneratorRepository implements DataRepository {

    private RestTemplate restTemplate;
    private final ApiIntegerGeneratorConfig config;

    @Override
    public Optional<Integer> getData() {
        try {
            return Optional.ofNullable(restTemplate.getForObject(config.getUrl(), Integer.class));
        } catch (RestClientException ex) {
            log.warn("Error during connecting to webservice", ex);
            return Optional.empty();
        }
    }
}
