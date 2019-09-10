package core.basesyntax;

public class BetDaoFactory {
    public static BetDao instance;

    public static BetDao getLibrary() {
        if(instance == null) {
            instance = new BetImp();
        }
        return instance;
    }
}
