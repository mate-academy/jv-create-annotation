package core.basesyntax;

import java.util.List;

public interface BetDao {
    void add(Bet bet);
    List<Bet> getAll();
}
