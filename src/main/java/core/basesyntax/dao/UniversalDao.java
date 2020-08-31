package core.basesyntax.dao;

import java.util.List;

public interface UniversalDao<T> {
    void add(T value);

    List<T> getAll();
}
