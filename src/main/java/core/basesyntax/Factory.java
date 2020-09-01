package core.basesyntax;

public class Factory {
    private static BetDao betDaoFactory;
    private static UserDao userDaoFactory;

    public static BetDao getBetDaoFactory() {
        if (betDaoFactory == null) {
            betDaoFactory = new BetDaoImpl();
        }
        return betDaoFactory;
    }

    public static UserDao getUserDaoFactory() {
        if (userDaoFactory == null) {
            userDaoFactory = new UserDaoImpl();
        }
        return userDaoFactory;
    }
}
