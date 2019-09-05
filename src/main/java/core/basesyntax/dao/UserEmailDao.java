package core.basesyntax.dao;

import core.basesyntax.model.UserEmail;

import java.util.List;

public interface UserEmailDao {
    void add(UserEmail userEmail);

    List<UserEmail> getAll();
}
