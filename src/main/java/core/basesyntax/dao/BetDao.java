package core.basesyntax.dao;

import core.basesyntax.models.BetModel;
import java.util.List;

public interface BetDao {
    void add(BetModel bet);

    List<BetModel> getAll();
}
