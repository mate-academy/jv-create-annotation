package core.basesyntax.dao;

import core.basesyntax.models.Human;
import java.util.List;

public interface HumanDao {

    void add(Human human);

    List<Human> getAll();
}
