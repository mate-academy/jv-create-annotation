package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Client;
import java.util.List;

@Dao
public class ClientDaoImpl implements ClientDao {
    @Override
    public void add(Client client) {
        Storage.clients.add(client);
    }

    @Override
    public List<Client> getAll() {
        return Storage.clients;
    }
}
