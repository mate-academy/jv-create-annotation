package core.basesyntax.dao;

import core.basesyntax.model.Client;
import java.util.List;

public interface ClientDao {

    void add(Client client);

    List<Client> getAll();
}
