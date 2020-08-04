package pl.ozdoba.datajoiner.domain;

class NoDataException extends RuntimeException {
    NoDataException(String message) {
        super(message);
    }
}
