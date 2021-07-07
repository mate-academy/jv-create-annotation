package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Person;

import java.util.List;

@Dao
public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        Storage.users.add(person);
    }

    @Override
    public List<Person> getAll() {
        return Storage.users;
    }
}
