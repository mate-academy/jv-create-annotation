package factory;

import dao.TabletDao;
import dao.TabletDaoImpl;

public class TabletDaoFactory {
    private static TabletDao instance;

    public static TabletDao getTabletDao() {
        if (instance == null) {
            instance = new TabletDaoImpl();
        }
        return instance;
    }
}
