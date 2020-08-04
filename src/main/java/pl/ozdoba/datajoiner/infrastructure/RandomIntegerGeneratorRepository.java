package pl.ozdoba.datajoiner.infrastructure;

import pl.ozdoba.datajoiner.domain.DataRepository;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class RandomIntegerGeneratorRepository implements DataRepository {
    private static final int MAX_NUMBER = 1001;

    @Override
    public Optional getData() {
        var randomNumber = ThreadLocalRandom.current().nextInt(0, MAX_NUMBER);
        return Optional.of(randomNumber);
    }
}
