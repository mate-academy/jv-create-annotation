package core.basesyntax.dao;

import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;

public interface UserDao {
    void addNewUser(UserDto userDto);
    User getUser(String login, String password);

}
