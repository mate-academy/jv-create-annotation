package core.basesyntax;

import java.util.List;

@Dao
public class CustomersImp implements CustomersDao {
    @Override
    public void add(Customers customers) {
        Storage.customers.add(customers);
    }

    @Override
    public List<Customers> getAll() {
        return Storage.customers;
    }
}
