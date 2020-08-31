package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Order;
import java.util.List;

@Dao
public class OrderDaoImpl implements OrderDao {
    @Override
    public void add(Order order) {
        Storage.orders.add(order);
    }

    @Override
    public List<Order> addAll() {
        return Storage.orders;
    }
}
