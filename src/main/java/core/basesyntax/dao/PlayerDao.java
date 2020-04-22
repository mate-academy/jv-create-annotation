package core.basesyntax.dao;

import core.basesyntax.model.Player;
import java.util.List;

public interface PlayerDao {

    public void add(Player player);

    public List<Player> getAll();
}
