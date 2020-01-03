package java.core.basesyntax.dao;

import java.core.basesyntax.model.Client;
import java.util.Set;

public interface ClientDao {
    void add(Client client);

    void delete(Client client);

    Set<Client> getAll();
}
