package core.basesyntax.command;

import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.UserExistException;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.User;

public class RegistrationCommandImpl implements Command {
    @Inject
    private UserDao userDao;

    @Override
    public void execute(String[] data) throws UserExistException {
        if (data == null) {
            throw new RuntimeException("Expected to receive data, but got null");
        }
        if (data.length != 4) {
            throw new IllegalArgumentException("");
        }
        try {
            String login = data[1];
            User user = userDao.getByLogin(login);
            if (user != null) {
                throw new UserExistException();
            }
            String password = data[2];
            int age = Integer.parseInt(data[3]);
            User newUser = new User(login, password, age);
            userDao.add(newUser);
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
