package dao;

import java.util.List;
import model.Human;

public interface HumanDao {

    void add(Human human);

    List<Human> getAll();
}
