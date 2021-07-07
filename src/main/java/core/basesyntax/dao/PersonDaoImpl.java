package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.library.Dao;
import core.basesyntax.model.Person;
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
