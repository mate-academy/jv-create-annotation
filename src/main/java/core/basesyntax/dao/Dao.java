package core.basesyntax.dao;

import java.util.List;

public interface Dao<T> {
    void add(T t);

    List<T> getAll();
}
