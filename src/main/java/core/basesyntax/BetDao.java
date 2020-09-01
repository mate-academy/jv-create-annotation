package core.basesyntax;

import java.util.List;
import java.util.Optional;

public interface BetDao {
    Optional<Bet> get(int id);

    List<Bet> getAll();

    boolean save(Bet bet);

    boolean delete(Integer id);
}
