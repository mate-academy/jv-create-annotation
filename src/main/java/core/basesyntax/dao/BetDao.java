package core.basesyntax.dao;

import core.basesyntax.model.Bet;
import core.basesyntax.mylibrary.Dao;
import java.util.List;

@Dao
public interface BetDao {
    public List<Bet> getAll();

    public void add(Bet bet);
}
