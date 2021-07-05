package core.basesyntax.dao;

import core.basesyntax.model.Gamer;
import java.util.List;

public interface GamerDao {
    List<Gamer> getAllGamers();

    void add(Gamer gamer);
}
