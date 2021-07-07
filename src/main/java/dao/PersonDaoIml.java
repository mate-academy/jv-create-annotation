package dao;

import static db.Storage.persons;

import db.Storage;
import java.util.List;
import lib.Dao;
import model.Person;

@Dao
public class PersonDaoIml implements PersonDao {

    @Override
    public void add(Person person) {
        persons.add(person);
    }

    @Override
    public List<Person> getAll() {
        return Storage.persons;
    }
}
