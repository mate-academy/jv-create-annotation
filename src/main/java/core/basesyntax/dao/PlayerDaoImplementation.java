package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Player;

import java.util.List;

@Dao
public class PlayerDaoImplementation implements PlayerDao {
    @Override
    public void add(Player player) {
        Storage.players.add(player);
    }

    @Override
    public List<Player> getAll() {
        return Storage.players;
    }
}
