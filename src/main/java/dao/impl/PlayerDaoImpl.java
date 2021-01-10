package dao.impl;

import static db.Storage.players;

import dao.PlayerDao;
import java.util.List;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }

    @Override
    public List<Player> getAll() {
        return players;
    }
}
