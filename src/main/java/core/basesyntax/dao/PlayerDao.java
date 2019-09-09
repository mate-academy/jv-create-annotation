package core.basesyntax.dao;

import core.basesyntax.model.Player;

import java.util.Set;

public interface PlayerDao {
    void add(Player player);

    Set<Player> getAll();
}
