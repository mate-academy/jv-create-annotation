package core.basesyntax.dao;

import core.basesyntax.model.Person;
import java.util.List;

public interface PersonDao {

    void add(Person user);

    List<Person> getAll();
}
