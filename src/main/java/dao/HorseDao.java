package dao;

import java.util.List;
import model.Horse;

public interface HorseDao {

    void add(Horse horse);

    List<Horse> getAll();
}
