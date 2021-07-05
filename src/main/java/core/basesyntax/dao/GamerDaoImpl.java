package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Gamer;
import java.util.List;

@Dao
public class GamerDaoImpl implements GamerDao {
    @Override
    public List<Gamer> getAllGamers() {
        return Storage.gamers;
    }

    @Override
    public void add(Gamer gamer) {
        Storage.gamers.add(gamer);
    }
}
