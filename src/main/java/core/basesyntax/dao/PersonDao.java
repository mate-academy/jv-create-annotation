package core.basesyntax.dao;

import core.basesyntax.model.Person;

public interface PersonDao {
    void addName(String name);

    Person getUserByName(String name);
}
