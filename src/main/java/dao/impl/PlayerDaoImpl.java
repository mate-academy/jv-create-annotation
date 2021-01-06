package dao.impl;

import static db.Storage.players;

import dao.PlayerDao;
import model.Player;

public class PlayerDaoImpl implements PlayerDao {

    @Override
    public void addPlayer(Player player) {
        players.add(player);
    }
}
