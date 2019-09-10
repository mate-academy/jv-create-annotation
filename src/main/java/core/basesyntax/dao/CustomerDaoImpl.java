package core.basesyntax.dao;

import core.basesyntax.lib.Dao;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Customer;


import java.util.List;

@Dao
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void add(Customer customers) {
        Storage.customers.add(customers);
    }

    @Override
    public List<Customer> getAll() {
        return Storage.customers;
    }
}
