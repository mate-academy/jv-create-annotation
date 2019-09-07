package factories;

import dao.CustomerDao;
import dao.CustomerDaoImpl;

public class CustomerDaoFactory {

    private static CustomerDao instance;

    public static CustomerDao getCustomerDao() {
        if (instance == null) {
            instance = new CustomerDaoImpl();
        }
        return instance;
    }
}
