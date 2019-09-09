package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Player;

import java.util.Set;

@Dao
public class PlayerDaoImpl implements PlayerDao {
    @Override
    public void add(Player player) {
        Storage.players.add(player);
    }

    @Override
    public Set<Player> getAll() {
        return Storage.players;
    }
}