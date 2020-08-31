package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Car;

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
}
