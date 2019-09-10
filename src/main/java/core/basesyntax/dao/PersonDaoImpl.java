package core.basesyntax.dao;

import core.basesyntax.database.Storage;
import core.basesyntax.lib.Account;
import core.basesyntax.models.Person;

import java.util.List;

@Account
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
