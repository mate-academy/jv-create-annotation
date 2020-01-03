package java.core.basesyntax.dao;

import java.core.basesyntax.db.Storage;
import java.core.basesyntax.lib.Dao;
import java.core.basesyntax.model.Client;

import java.util.Set;

@Dao
public class ClientDaoImpl implements ClientDao {

    @Override
    public void add(Client client) {
        Storage.client.add(client);
    }

    @Override
    public void delete(Client client) {
        Storage.client.remove(client);
    }

    @Override
    public Set<Client> getAll() {
        return Storage.client;
    }
}
