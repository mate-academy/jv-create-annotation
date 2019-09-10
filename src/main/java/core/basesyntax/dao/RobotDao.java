package core.basesyntax.dao;

import core.basesyntax.model.Robot;
import java.util.List;

public interface RobotDao {

    void add(Robot robot);

    Robot get(int index);

    List<Robot> getAll();
}
