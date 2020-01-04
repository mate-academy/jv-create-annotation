package core.basesyntax.dao;

import core.basesyntax.database.PersonDataBase;
import core.basesyntax.model.Person;
import java.util.List;

public class PersonDaoImplantation implements PersonDao {

    @Override
    public void add(Person person) {
        PersonDataBase.PersonData.add(person);
    }

    @Override
    public List<Person> getAll() {
        return PersonDataBase.PersonData;
    }
}
