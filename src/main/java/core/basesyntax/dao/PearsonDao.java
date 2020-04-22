package core.basesyntax.dao;

import core.basesyntax.model.Pearson;
import java.util.List;

public interface PearsonDao {
    void add(Pearson pearson);

    List<Pearson> getAll();
}
