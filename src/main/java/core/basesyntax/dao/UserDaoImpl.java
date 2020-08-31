package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.lib.Dao;
import core.basesyntax.model.Bet;
import core.basesyntax.model.User;
import java.util.List;

@Dao
public class UserDaoImpl implements UserDao {
    public boolean isLegalGambling(User user) {
        if (user == null) {
            System.out.println("Minimum user information in appropriate format "
                    + "must be provided to be sure you are allowed to make debts");
            return false;
        } else if (user.getAge() < 21) {
            System.out.println("It's not legal to make debts under age of 21! "
                    + "But feel free to explore the app as a guest user");
            return false;
        }
        return true;
    }

    @Override
    public void saveAsGambler(User user) {
        if (isLegalGambling(user)) {
            Storage.LEGIT_GAMBLERS.add(user);
        }
    }

    @Override
    public List<User> getAllGamblers() {
        return Storage.LEGIT_GAMBLERS;
    }

    @Override
    public void makeBet(User user, Bet bet) {
        user.getUserBets().add(bet);
    }
}
