package core.basesyntax.DAO;

import core.basesyntax.model.Casino;

import java.util.List;

public interface CasinoDAO {
    public void add(Casino casino);
    public List<Casino> getAll();
}
