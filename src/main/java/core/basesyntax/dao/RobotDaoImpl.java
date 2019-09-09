package core.basesyntax.dao;

import core.basesyntax.database.ImagineDatabase;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Robot;
import java.util.List;

@Dao
public class RobotDaoImpl implements RobotDao {

    @Override
    public void add(Robot robot) {
        ImagineDatabase.storageOfRobots.add(robot);
    }

    @Override
    public Robot get(int index) {
        return ImagineDatabase.storageOfRobots.get(index);
    }

    @Override
    public List<Robot> getAll() {
        return ImagineDatabase.storageOfRobots;
    }
}
