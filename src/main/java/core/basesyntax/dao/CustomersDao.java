package core.basesyntax.dao;

import core.basesyntax.model.Customers;

import java.util.List;

public interface CustomersDao {
    void add(Customers customers);
    List<Customers> getAll();
}
