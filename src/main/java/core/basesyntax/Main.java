package core.basesyntax;

import core.basesyntax.controllers.ConsoleHandler;
import core.basesyntax.dao.BetDao;
import core.basesyntax.dao.BetDaoImp;
import core.basesyntax.dao.LotteryDao;
import core.basesyntax.dao.LotteryDaoImp;
import core.basesyntax.lib.Injector;

public class Main {
    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("Choose a game: "
                + "\n1. Stake"
                + "\n2. Lottery");
        ConsoleHandler.handle();
        BetDao betDao = new BetDaoImp();
        LotteryDao lotteryDao = new LotteryDaoImp();
        if (betDao.getAll().size() > 0) {
            System.out.println(betDao.getAll());
        }
        if (lotteryDao.getAll().size() > 0) {
            System.out.println(lotteryDao.getAll());
        }
    }
}
