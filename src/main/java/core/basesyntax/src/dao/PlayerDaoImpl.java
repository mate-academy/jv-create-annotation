package core.basesyntax.src.dao;

import core.basesyntax.src.db.Storage;
import core.basesyntax.src.lib.Dao;
import core.basesyntax.src.model.Player;

import java.util.List;

@Dao
public class PlayerDaoImpl implements PlayerDao {

    @Override
    public void add(Player player) {
        Storage.players.add(player);
    }

    @Override
    public List<Player> getAll() {
        return Storage.players;
    }
}
