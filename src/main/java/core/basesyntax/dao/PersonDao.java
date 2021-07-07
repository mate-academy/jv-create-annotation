package core.basesyntax.dao;

import core.basesyntax.model.Person;
import java.util.HashSet;

public interface PersonDao {
    void add(Person person);

    HashSet<Person> getAll();
}
