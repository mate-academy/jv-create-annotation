package core.basesyntax.dao;

import core.basesyntax.model.Person;
import core.basesyntax.mylibrary.Dao;
import java.util.List;

@Dao
public interface PersonDao {
    void add(Person data);

    List<Person> getAll();

}
