package core.basesyntax.service;

public interface Mapper<T> {
    T parse(String[] data);
}
