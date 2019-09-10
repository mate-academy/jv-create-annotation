package core.basesyntax.dao;

import core.basesyntax.models.Person;

import java.util.List;

public interface PersonDao {
    public void add(Person person);

    List<Person> getAll();
}
