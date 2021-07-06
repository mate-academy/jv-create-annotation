package dao;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.Person;

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
