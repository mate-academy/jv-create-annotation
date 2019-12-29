package factory;

import dao.HumanDao;
import dao.HumanDaoIml;

public class HumanDaoFactory {

    private static HumanDaoIml instance;

    public static HumanDao getHumanDao() {
        if (instance == null) {
            instance = new HumanDaoIml();
        }
        return instance;
    }
}
