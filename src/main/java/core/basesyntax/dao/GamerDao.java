package core.basesyntax.dao;

import core.basesyntax.model.Gamer;

import java.util.List;

public interface GamerDao {

    void add(Gamer gamer);

    List<Gamer> getAll();
}
