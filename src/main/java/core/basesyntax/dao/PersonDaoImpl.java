package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.models.Person;

import java.util.List;

@Dao
public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        Storage.persons.add(person);
    }

    @Override
    public List<Person> getAll() {
        return Storage.persons;
    }
}
