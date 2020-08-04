package pl.ozdoba.datajoiner.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@RequiredArgsConstructor
@Slf4j
public class DataJoinerService<T> {

    private final DataRepository<T> firstDataSource;
    private final DataRepository<T> secondDataSource;
    private final DataOperator<T> dataOperation;

    public T joinData() {
        var firstData = firstDataSource.getData()
                .orElseThrow(createNoDataDoundException());
        var secondData = secondDataSource.getData()
                .orElseThrow(createNoDataDoundException());
        return dataOperation.join(firstData, secondData);
    }

    private Supplier<NoDataException> createNoDataDoundException() {
        return () -> new NoDataException("Cannot get data from repository");
    }

}
