package core.basesyntax;

public class Factory {
    private static BetDao betDaoFactory;
    private static UserDao userDaoFactory;

    public static BetDao getBetDao() {
        if (betDaoFactory == null) {
            betDaoFactory = new BetDaoImpl();
        }
        return betDaoFactory;
    }

    public static UserDao getUserDao() {
        if (userDaoFactory == null) {
            userDaoFactory = new UserDaoImpl();
        }
        return userDaoFactory;
    }
}
