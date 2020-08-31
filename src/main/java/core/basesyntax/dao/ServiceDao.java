package core.basesyntax.dao;

import java.util.List;

public interface ServiceDao<T> {

    void add(T item);

    List<T> getAll();
}
