package core.basesyntax.dao;

import core.basesyntax.model.Person;
import java.util.List;

public interface PersonDao {
    void addPerson(Person person);

    List<Person> getPeople();
}
