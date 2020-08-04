package pl.ozdoba.datajoiner.domain;

interface DataOperator<T> {
    T join(T firstData, T secondData);
}
