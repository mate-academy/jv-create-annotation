package core.basesyntax.src.dao;

import core.basesyntax.src.model.Player;

import java.util.List;

public interface PlayerDao {

    void add(Player player);

    List<Player> getAll();
}
