package core.basesyntax.dao;

import core.basesyntax.model.Person;
import java.util.ArrayList;

public interface PersonDao {
    void add(Person person);

    ArrayList<Person> getAll();
}
