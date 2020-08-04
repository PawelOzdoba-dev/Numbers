package pl.ozdoba.datajoiner.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class DataJoinerServiceTest {

    private DataRepository<Integer> generatorDataRepository;
    private DataRepository<Integer> apiDataRepository;
    private DataJoinerService<Integer> dataJoinerService;

    @BeforeEach
    void setup() {
        var configuration = new DataJoinerServiceConfiguration();
        generatorDataRepository = configuration.generatorDataRepository;
        apiDataRepository = configuration.apiDataRepository;
        dataJoinerService = configuration.createDataJoinerService();
    }

    @Test
    void shouldAddTwoIntegers() {
        //given
        when(generatorDataRepository.getData()).thenReturn(Optional.of(6));
        when(apiDataRepository.getData()).thenReturn(Optional.of(2));

        //when
        var sum = dataJoinerService.joinData();

        //then
        assertThat(sum).isEqualTo(8);
    }

    @Test
    void shouldThrowExceptionWhenNotData() {
        //given
        when(generatorDataRepository.getData()).thenReturn(Optional.empty());
        when(apiDataRepository.getData()).thenReturn(Optional.of(2));

        //when
        var exception = assertThrows(NoDataException.class,
                () -> dataJoinerService.joinData());

        //then
        assertThat(exception).isNotNull();
    }
}
