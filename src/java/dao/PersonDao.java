package dao;

import model.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);

    List<Person> getAll();
}
