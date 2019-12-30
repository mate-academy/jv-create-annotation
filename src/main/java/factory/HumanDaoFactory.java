package factory;

import dao.HumanDao;
import dao.HumanDaoImpl;

public class HumanDaoFactory {

    private static HumanDao instance;

    public static HumanDao getHumanDao() {
        return instance == null ? instance = new HumanDaoImpl() : instance;
    }
}
