package dao.implementation;

import dao.PersonDao;
import db.Storage;
import model.Person;

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
