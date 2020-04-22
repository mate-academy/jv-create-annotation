package core.basesyntax.dao;

import core.basesyntax.model.Credit;
import java.util.List;

public interface CreditDao {

    void add(Credit client);

    List<Credit> getAll();
}
