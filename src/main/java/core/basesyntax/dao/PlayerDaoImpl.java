package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Player;
import java.util.List;

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
