package pl.ozdoba.datajoiner.infrastructure;

import pl.ozdoba.datajoiner.domain.DataRepository;

import java.util.Optional;
import java.util.Random;

public class RandomIntegerGeneratorRepository implements DataRepository {
    private static final int MAX_NUMBER = 1000;
    private Random randomGenerator = new Random(); //TODO to change

    @Override
    public Optional getData() {
        var randomNumber = randomGenerator.nextInt(MAX_NUMBER);
        return Optional.of(randomNumber);
    }
}
