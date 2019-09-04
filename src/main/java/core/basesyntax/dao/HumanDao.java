package core.basesyntax.dao;

import core.basesyntax.model.Human;

import java.util.List;

public interface HumanDao {
    public void add(Human human);

    List<Human> getAll();
}
