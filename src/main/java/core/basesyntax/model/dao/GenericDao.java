package core.basesyntax.model.dao;

import java.util.List;

public interface GenericDao<T> {

    void add(T t);

    List<T> getAll();
}
