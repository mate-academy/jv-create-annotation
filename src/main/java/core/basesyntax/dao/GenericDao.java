package core.basesyntax.dao;

import java.util.List;

public interface GenericDao<T> {
    void addModelToDb(T model);

    List<T> getAll();
}
