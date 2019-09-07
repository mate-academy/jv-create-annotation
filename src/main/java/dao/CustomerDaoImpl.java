package dao;

import database.Storage;
import java.util.List;
import lib.Dao;
import models.Customer;

@Dao
public class CustomerDaoImpl implements CustomerDao {

    @Override
    public void add(Customer customer) {
        Storage.customers.add(customer);
    }

    @Override
    public List<Customer> getAll() {
        return Storage.customers;
    }
}
