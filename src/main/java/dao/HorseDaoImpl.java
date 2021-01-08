package dao;

import model.Horse;

public class HorseDaoImpl implements HorseDao {
    @Override
    public void changeName(Horse horse, String newName) {
        horse.setName(newName);
    }
}
