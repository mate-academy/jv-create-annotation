package core.basesyntax.dao;

public class BetDaoFactory {
    private static BetDao instance;

    public static BetDao getBetDao() {
        if (instance == null) {
            instance = new BetDaoImpl();
        }
        return instance;
    }
}
