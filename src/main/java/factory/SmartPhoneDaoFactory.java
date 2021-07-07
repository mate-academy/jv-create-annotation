package factory;

import dao.SmartPhoneDao;
import dao.SmartPhoneDaoImpl;

public class SmartPhoneDaoFactory {
    private static SmartPhoneDao instance;

    public static SmartPhoneDao getSmartPhoneDao() {
        if (instance == null) {
            instance = new SmartPhoneDaoImpl();
        }
        return instance;
    }
}
