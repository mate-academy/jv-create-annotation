package dao;

import java.util.List;

import model.Human;

public interface HumanDao {
    void addHuman(Human human);

    List<Human> getAll();
}
