package core.basesyntax.dao;

import core.basesyntax.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.models.Animal;
import java.util.List;

@Dao
public class AnimalDaoImpl implements AnimalDao {

    @Override
    public void add(Animal animal) {
        Storage.animals.add(animal);
    }

    @Override
    public List<Animal> getAll() {
        return Storage.animals;
    }
}