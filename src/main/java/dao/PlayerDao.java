package dao;

import java.util.List;
import model.Player;

public interface PlayerDao {
    void addPlayer(Player player);

    List<Player> getAll();
}
