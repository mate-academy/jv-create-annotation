package dao;

import db.Storage;
import java.util.List;
import model.Person;

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
