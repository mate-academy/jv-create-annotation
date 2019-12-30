package core.basesyntax.factory;

import core.basesyntax.dao.LotteryDao;
import core.basesyntax.dao.LotteryDaoImp;

public class LotteryDaoFactory {
    private static LotteryDao lotteryDao;

    public static LotteryDao getLotteryDao() {
        if (lotteryDao == null) {
            lotteryDao = new LotteryDaoImp();
        }
        return lotteryDao;
    }
}
