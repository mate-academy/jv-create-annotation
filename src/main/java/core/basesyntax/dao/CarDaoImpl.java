package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Car;
import java.util.List;

@Dao
public class CarDaoImpl implements CarDao {
    @Override
    public void add(Car car) {
        Storage.CARS_STORAGE.add(car);
    }

    @Override
    public Car getByModel(String model) {
        return Storage.CARS_STORAGE.stream()
                .filter(car -> car.equals(model))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(Car car) {
        return Storage.CARS_STORAGE.remove(car);
    }

    @Override
    public List<Car> getAll() {
        return Storage.CARS_STORAGE;
    }
}
