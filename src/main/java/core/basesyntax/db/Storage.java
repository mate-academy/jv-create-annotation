package core.basesyntax.db;

import core.basesyntax.model.User;
import core.basesyntax.model.UserEmail;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static final List<UserEmail> emails = new ArrayList<>();
    public static final List<User> persons = new ArrayList<>();
}
