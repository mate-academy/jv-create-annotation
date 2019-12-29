package dao;

import model.Human;

import java.util.List;

public interface HumanDao {
    void addHuman(Human human);
    List<Human> getAll();
}
