package core.basesyntax.controller;

import core.basesyntax.dao.RobotDao;
import core.basesyntax.lib.InjectDao;
import core.basesyntax.model.Robot;

public class Controller {
    @InjectDao
    private static RobotDao robotDao;

    public static void controlProcess() {
        System.out.println("start making robots");
        robotDao.add(new Robot(1.1, "WALL-E"));
        robotDao.add(new Robot(11.2, "BostonDynamics"));
        robotDao.add(new Robot(2.0, "Siri"));
        System.out.println("robots are made");

        System.out.println(robotDao.getAll());
    }
}
