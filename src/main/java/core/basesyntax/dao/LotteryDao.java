package core.basesyntax.dao;

import core.basesyntax.model.Lottery;

import java.util.List;

public interface LotteryDao {
    void add(Lottery lottery);

    List<Lottery> getAll();
}
