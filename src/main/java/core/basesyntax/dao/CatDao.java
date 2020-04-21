package core.basesyntax.dao;

import core.basesyntax.model.Cat;
import java.util.List;

public interface CatDao {
    void add(Cat cat);

    List<Cat> getAll();
}
