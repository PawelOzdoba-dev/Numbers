package pl.ozdoba.datajoiner.domain;

import org.mockito.Mockito;

public class DataJoinerServiceConfiguration {

    DataRepository<Integer> generatorDataRepository = Mockito.mock(DataRepository.class);
    DataRepository<Integer> apiDataRepository = Mockito.mock(DataRepository.class);

    DataJoinerService<Integer> createDataJoinerService() {
        return new DataJoinerService<>(
                generatorDataRepository,
                apiDataRepository,
                new AddIntegersOperator()
        );
    }
}
