package core.basesyntax.dao;

import core.basesyntax.model.Check;

import java.util.List;

public interface CheckDao {
    void add(Check check);

    List<Check> getAll();
}
