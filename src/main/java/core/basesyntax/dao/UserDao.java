package core.basesyntax.dao;

import core.basesyntax.models.UserModel;
import java.util.List;

public interface UserDao {
    void addUser(UserModel user);

    List<UserModel> users();


}
