package core.basesyntax.service.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.WrongLoginOrPasswordException;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.User;
import core.basesyntax.service.AuthorizationService;

public class AuthorizationServiceImpl implements AuthorizationService {
    @Inject
    private UserDao userDao;

    public User authorize(String login, String password) throws WrongLoginOrPasswordException {
        if (login == null || password == null) {
            throw new RuntimeException("Expected to receive data, but got null");
        }
        User user = userDao.getByLogin(login);
        if (user == null || !user.getPassword().equals(password)) {
            throw new WrongLoginOrPasswordException("Authorisation Error: wrong login or password");
        }
        return user;
    }
}
