package core.basesyntax.dao;

import core.basesyntax.model.BetUser;
import java.util.List;

public interface BetUserDao {

    public void add(BetUser betUser);

    public List<BetUser> getAll();
}
