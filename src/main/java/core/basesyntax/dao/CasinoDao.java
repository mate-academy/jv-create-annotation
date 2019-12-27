package core.basesyntax.dao;

import core.basesyntax.model.Casino;

import java.util.List;

public interface CasinoDao {
    public void add(Casino casino);

    public List<Casino> getAll();
}
