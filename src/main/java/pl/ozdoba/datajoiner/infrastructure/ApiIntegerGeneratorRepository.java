package pl.ozdoba.datajoiner.infrastructure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.ozdoba.datajoiner.domain.DataRepository;

import java.util.List;
import java.util.Optional;

import static java.lang.Integer.valueOf;

@Slf4j
@RequiredArgsConstructor
public class ApiIntegerGeneratorRepository implements DataRepository {

    private final RestTemplate restTemplate;
    private final ApiIntegerGeneratorConfig config;

    @Override
    public Optional<Integer> getData() {
        try {
            Optional<String> apiIntegerGenerator = Optional.ofNullable(restTemplate.getForObject(config.getUrl(), String.class));
            return apiIntegerGenerator.isPresent() ? mapToInteger(apiIntegerGenerator.get()) : Optional.empty();
        } catch (RestClientException ex) {
            log.warn("Error during connecting to webservice", ex);
            return Optional.empty();
        }
    }

    private Optional<Integer> mapToInteger(String number) {
        return Optional.of(valueOf(replaceChars(number)));
    }

    private String replaceChars(String number) {
        number = number.replaceAll("[' ','\\n']", "");
        return number;
    }
}
