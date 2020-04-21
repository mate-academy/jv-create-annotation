package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Person;
import java.util.List;

public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        Storage.people.add(person);
    }

    @Override
    public List<Person> getAll() {
        return Storage.people;
    }
}
