package core.basesyntax.dao;

import java.util.List;

public interface BaseDao<T> {
    void add(T item);

    List<T> getAll();
}
