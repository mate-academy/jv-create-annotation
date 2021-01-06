package dao.impl;

import dao.PlayerDao;
import model.Player;
import static db.Storage.players;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }
}
