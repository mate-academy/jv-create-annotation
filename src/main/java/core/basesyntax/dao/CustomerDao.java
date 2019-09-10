package core.basesyntax.dao;

import core.basesyntax.model.Customer;

import java.util.List;

public interface CustomerDao {

    void add(Customer customers);

    List<Customer> getAll();
}
