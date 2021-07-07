package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Person;
import java.util.List;

@Dao
public class PersonDaoImpl implements PersonDao {

    @Override
    public void addPerson(Person person) {
        Storage.people.add(person);
    }

    @Override
    public List<Person> getPeople() {
        return Storage.people;
    }
}
