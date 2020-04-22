package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Person;

@Dao
public class PersonDaoImpl implements PersonDao {

    @Override
    public void addName(String name) {
        Person person = new Person();
        person.setName(name);
        Storage.personData.add(person);
    }

    @Override
    public Person getUserByName(String name) {
        for (Person nm : Storage.personData) {
            if (nm.getName().equals(name)) {
                return nm;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Storage.personData.toString();
    }
}
