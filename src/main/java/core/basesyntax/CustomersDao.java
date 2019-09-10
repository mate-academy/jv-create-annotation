package core.basesyntax;

import java.util.List;

public interface CustomersDao {
    void add(Customers customers);
    List<Customers> getAll();
}
