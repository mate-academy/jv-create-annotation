package core.basesyntax.dao;

import core.basesyntax.models.Animal;

import java.util.List;

public interface AnimalDao {
    void add(Animal animal);

    List<Animal> getAll();
}