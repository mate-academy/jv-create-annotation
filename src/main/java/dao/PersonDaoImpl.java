package dao;

import core.basesyntax.model.Person;
import database.Storage;
import java.util.List;
import lib.Dao;

@Dao
public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        Storage.persons.add(person);
    }

    @Override
    public List<Person> getAllPersons() {
        return Storage.persons;
    }
}
