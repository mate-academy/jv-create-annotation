package core.basesyntax.db;

import core.basesyntax.models.BetModel;
import core.basesyntax.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<BetModel> bets = new ArrayList<>();
    public static final List<UserModel> users = new ArrayList<>();
}
