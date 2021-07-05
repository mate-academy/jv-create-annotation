package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Car;
import java.util.List;

@Dao
public class CarDaoImpl implements CarDao {
    @Override
    public void add(Car car) {
        Storage.carsStorage.add(car);
    }

    @Override
    public Car getByModel(String model) {
        return Storage.carsStorage.stream()
                .filter(car -> car.equals(model))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean remove(Car car) {
        return Storage.carsStorage.remove(car);
    }

    @Override
    public List<Car> getAll() {
        return Storage.carsStorage;
    }
}
