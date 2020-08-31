package core.basesyntax.dao;

import core.basesyntax.controller.ConsoleHandler;
import core.basesyntax.model.User;
import core.basesyntax.model.UserDto;
import core.basesyntax.storage.ListStorageUser;

public class UserDaoImpl implements UserDao {
    @Override
    public void addNewUser(UserDto userDto) {
        ListStorageUser listStorageUser = new ListStorageUser();
        listStorageUser.addUser(userDto);
    }

    @Override
    public User getUser(String login, String password) {
        User.UserBuilder userBuilder = new User.UserBuilder();
        if ((login == null || password == null)
                && (login.length() == 0 || password.length() == 0)) {
            getLoginPassword();
        }
        boolean loginNotExist = false;
        for (User user : ListStorageUser.userList) {
            if (user.getLogin().equals(login)) {
                loginNotExist = true;
                if (user.getPassword().equals(password)) {
                    System.out.println("User has been found, login successful.");
                    return user;
                }
            }
        }
        if (loginNotExist) {
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.handler();
        }

        return userBuilder.setLogin(login).setPassword(password).build();
    }

    public void getLoginPassword() {
        System.out.println("Entered login/password is incorrect, try again");
        ConsoleHandler handler = new ConsoleHandler();
        handler.readUser();
    }
}
