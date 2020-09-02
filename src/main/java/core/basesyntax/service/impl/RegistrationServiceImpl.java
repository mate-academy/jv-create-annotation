package core.basesyntax.service.impl;

import core.basesyntax.dao.UserDao;
import core.basesyntax.exception.DuplicateUserException;
import core.basesyntax.exception.InvalidAgeException;
import core.basesyntax.lib.Inject;
import core.basesyntax.model.User;
import core.basesyntax.service.RegistrationService;

public class RegistrationServiceImpl implements RegistrationService {
    @Inject
    private UserDao userDao;

    public void register(User newUser) throws DuplicateUserException, InvalidAgeException {
        if (newUser == null) {
            throw new RuntimeException("Expected to receive user, but got null");
        }
        User user = userDao.getByLogin(newUser.getLogin());
        if (user != null) {
            throw new DuplicateUserException("Registration Error: "
                    + "user with this login already exists");
        }
        if (newUser.getAge() < 18) {
            throw new InvalidAgeException("Registration Error: too young");
        }
        userDao.add(newUser);
    }
}
