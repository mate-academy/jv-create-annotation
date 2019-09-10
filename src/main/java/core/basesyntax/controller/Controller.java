package core.basesyntax.controller;

import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.RobotDao;
import core.basesyntax.lib.InjectDao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.Robot;

public class Controller {
    @InjectDao
    private static RobotDao robotDao;

    @InjectDao
    private static BetDao betDao;

    public static void controlProcess() {
        System.out.println("start making robots");
        robotDao.add(new Robot(1.1, "WALL-E"));
        robotDao.add(new Robot(11.2, "BostonDynamics"));
        robotDao.add(new Robot(2.0, "Siri"));
        System.out.println("robots are made");
        System.out.println(robotDao.getAll());

        System.out.println("robots making bets");
        betDao.add(new Bet(100, 0.5));
        betDao.add(new Bet(900, 1.1));
        betDao.add(new Bet(3000, 0.7));
        System.out.println("bets are made");
        System.out.println(betDao.getAll());
    }
}
