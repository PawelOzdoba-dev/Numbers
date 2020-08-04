package pl.ozdoba.datajoiner.domain;

import java.util.Optional;

public interface DataRepository<T> {
    Optional<T> getData();
}
