package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Person;
import java.util.ArrayList;

@Dao
public class PersonDaoImpl implements PersonDao {
    @Override
    public void add(Person person) {
        if (!(Storage.persons.contains(person))) {
            Storage.persons.add(person);
        }
    }

    @Override
    public ArrayList<Person> getAll() {
        return Storage.persons;
    }
}
