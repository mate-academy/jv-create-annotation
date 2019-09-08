package core.basesyntax.dao;

import core.basesyntax.AnimalDB;
import core.basesyntax.lib.Dao;
import core.basesyntax.models.Animal;

import java.util.List;

@Dao
public class AnimalDaoImpl implements AnimalDao {

    @Override
    public void add(Animal animal) {
        AnimalDB.animals.add(animal);
    }

    @Override
    public List<Animal> getAll() {
        return AnimalDB.animals;
    }
}
