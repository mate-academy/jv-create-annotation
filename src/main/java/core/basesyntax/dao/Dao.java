package core.basesyntax.dao;

import java.util.List;

public interface Dao<T> {
    void add(T value);

    List<T> getAll();
}
