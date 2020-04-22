package dao;

import core.basesyntax.model.Person;
import java.util.List;

public interface PersonDao {

    void add(Person person);

    List<Person> getAllPersons();
}
