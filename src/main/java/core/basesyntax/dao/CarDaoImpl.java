package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Car;
import java.util.NoSuchElementException;

public class CarDaoImpl implements CarDao {
    @Override
    public void add(Car car) {
        Storage.cars_storage.add(car);
    }

    @Override
    public Car getByModel(String model) {
        for (Car car : Storage.cars_storage) {
            if (car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return Storage.cars_storage.remove(car);
    }

    @Override
    public void updateMaxSpeed(Car car, int maxSpeed) {
        int index = Storage.cars_storage.indexOf(car);
        if (index != -1) {
            Storage.cars_storage.get(index).setMaxSpeed(maxSpeed);
            return;
        }
        throw new NoSuchElementException("No such element");
    }
}
