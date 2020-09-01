package core.basesyntax;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {
    Optional<T> get(int id);

    List<T> getAll();

    boolean save(T t);

    boolean delete(Integer id);
}
