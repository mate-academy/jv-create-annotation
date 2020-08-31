package core.basesyntax.dao;

import java.util.List;

public interface ModelDao<T> {
    void addModelToDb(T model);

    List<T> getAll();
}
