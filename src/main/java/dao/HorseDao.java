package dao;

import model.Horse;

public interface HorseDao {
    void changeName(Horse horse, String newName);
}
