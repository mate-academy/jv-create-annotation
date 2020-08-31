package core.basesyntax.dao;

import core.basesyntax.model.Car;

public interface CarDao {
    void add(Car car);

    Car getByModel(String model);
}
